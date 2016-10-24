/*
 loriacarlos@gmail.com EIF400 II-2016
 EightBit starting compiler
*/
package eightBit.compile;


import eightBit.js.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.stream.*;


public class Compiler extends EightBitBaseVisitor<ASMAst> implements JSEmiter{
   protected ASMAst program;
   private SimbolTable simbolTable;
   private HashMap<String, String> jumps = new HashMap<>();
   protected List<ASMAst> codeArea = new ArrayList<>();

   public ASMAst getProgram(){
	   return this.program;
   }

   public void genCode(){
	  this.codeArea.stream().forEach(t -> t.genCode());
   }

   public ASMAst compile(ParseTree tree){
	  this.simbolTable = new SimbolTable();
    generateJumps();
    return visit(tree);
   }


   @Override
   public ASMAst visitEightProgram(EightBitParser.EightProgramContext ctx){
	  codeArea.add( ID("\n.init:"));
		codeArea.add( MOV(ID("D"), ID("232")) );
		codeArea.add( JMP( ID("main")));
		codeArea.add( ID("\n\t.UNDEF: DB 255;"));
    	codeArea.add( STRING(".true","\"true\""));
    	codeArea.add( STRING(".false","\"false\""));
		
		ctx.eightFunction().stream()
	                      .forEach( fun -> visit(fun) );
		this.codeArea.addAll(4,genDataSegment());
	   return this.program = PROGRAM(this.codeArea);
   }


   @Override
   public ASMAst visitEightFunction(EightBitParser.EightFunctionContext ctx){
	    ASMId id = (ASMId)visit(ctx.id());
		  ASMBlock formals= (ASMBlock) visit(ctx.formals()); //Interceptar la lista de formals
	    ASMAst body = visit(ctx.funBody());

		//solo metodos que no son main tiene el prologo
		ASMAst prolog= id.getValue().equals("main")? BLOCK():BLOCK(generateProlog(formals.getMembers()));

		ASMAst ret = id.getValue().equals("main")? BLOCK(DATA(HLT())):BLOCK(generateRet(formals.getMembers()));

		ASMFunction function = FUNCTION(id,JoinBlock(JoinBlock(prolog,body),ret));

		if(id.getValue().equals("main")){
			 this.codeArea.add(PRINTS());
			 this.codeArea.add(PRINTN());
       this.codeArea.add(PRINTB());
		}

		this.codeArea.add(function);
		return  function;
   }


	@Override
	public ASMAst visitFormals(EightBitParser.FormalsContext ctx){
	   EightBitParser.IdListContext idList = ctx.idList();
	   return (idList == null ) ? BLOCK()
	                            : visit(idList);
   }

   @Override
   public ASMAst visitIdList(EightBitParser.IdListContext ctx){
		List<ASMAst> lista=	 ctx.id().stream()
									 .map( c -> visit(c))
									 .collect(Collectors.toList());
		return BLOCK(lista);
   }
   	
	@Override 
	public ASMAst visitLetStatement(EightBitParser.LetStatementContext ctx) { 
		List<ASMAst> l =new ArrayList<>();
		l.add(visit(ctx.assignStmtList()));
		l.add(visit(ctx.closedStatement()));
		return BLOCK(l);
	}

	   
 @Override
 public ASMAst visitAssignStatement(EightBitParser.AssignStatementContext ctx){
	ASMId varName= (ASMId)visit(ctx.id());
	
	List<ASMAst> l = new ArrayList<>();
	l.add(visit(ctx.expr()));
	l.add(POP(ID("A")));
	l.add(MOV(varName, ID("A")) );
	return BLOCK(l);
 }

	
   @Override
   public ASMAst visitBlockStatement(EightBitParser.BlockStatementContext ctx){
      EightBitParser.ClosedListContext closedList = ctx.closedList();
      return (closedList == null ) ? BLOCK()
	                                 : visit(closedList);
   }

   @Override
   public ASMAst visitClosedList(EightBitParser.ClosedListContext ctx){
					   return  BLOCK(ctx.closedStatement()
                              .stream()
	                            .map( c -> visit(c))
						         .collect(Collectors.toList()));

   }

   @Override
   public ASMAst visitReturnStatement(EightBitParser.ReturnStatementContext ctx){
		return visit(ctx.expr());
   }

   @Override
   public ASMAst visitId(EightBitParser.IdContext ctx){
	  //pregunta si el string es un id de una funcion o de una variable
	  return ctx.getParent() instanceof EightBitParser.EightFunctionContext ?
								ID( this.simbolTable.addFun(ctx.ID().getText())): visitVar(ctx);
   }


    public ASMAst visitVar(EightBitParser.IdContext ctx){
	  return isVarAssigment(ctx) ? ID('['+this.simbolTable.getPrimeVal(ctx.ID().getText())+']')
								: isVarDeclaration(ctx)? ID('['+this.simbolTable.addVar(ctx.ID().getText()) +']')
											:PUSH (ID('['+this.simbolTable.getPrimeVal(ctx.ID().getText())+']'));

   }

   public Boolean isVarDeclaration(EightBitParser.IdContext ctx){
	   return ctx.getParent() instanceof EightBitParser.IdListContext ||
				ctx.getParent().getParent() instanceof EightBitParser.AssignStmtListContext;
   }
   
   public Boolean isVarAssigment(EightBitParser.IdContext ctx){
	   return ctx.getParent() instanceof EightBitParser.AssignStatementContext 
				&& !(ctx.getParent().getParent() instanceof EightBitParser.AssignStmtListContext);
   }

   @Override
   public ASMAst visitArithOperation(EightBitParser.ArithOperationContext ctx) {
	    if (ctx.operArithOperation().size() == 0)
			return visit(ctx.arithMonom());
		
		ASMAst operLeft = visit(ctx.arithMonom());
		ASMAst operRight = visit(ctx.operArithOperation().get(0).arithMonom());
		String operator = ctx.operArithOperation().get(0).oper.getText();

		List<ASMAst> l = new ArrayList<>();
		l.add(operLeft);
		l.add(operRight);
		l.add(POP(ID("B")));
		l.add(POP(ID("A")));
		l.add(operator.equals("+")?ADD(ID("A"),ID("B")): SUB(ID("A"),ID("B")));
		l.add(PUSH(ID("A")));
		ctx.operArithOperation().stream()
								.skip(1)
								.forEach(c->l.add(visit(c)));	
		return BLOCK(l);
   }
   
   	@Override 
	public ASMAst visitOperArithOperation(EightBitParser.OperArithOperationContext ctx) { 
		List<ASMAst> l = new ArrayList<>();
		l.add(visit(ctx.arithMonom()));
		l.add(POP(ID("B")));
		l.add(POP(ID("A")));
		l.add(ctx.oper.getText().equals("+")?ADD(ID("A"),ID("B")): SUB(ID("A"),ID("B")));
		l.add(PUSH(ID("A")));
		return BLOCK(l); 
	}
   
  
   	@Override
	public ASMAst visitExprNum(EightBitParser.ExprNumContext ctx) {
		return PUSH(ID(ctx.NUMBER().getText()));
	}
	
	  @Override
  public ASMAst visitArithMonom(EightBitParser.ArithMonomContext ctx){
		if (ctx.operTDArithSingle().size() == 0)
			return visit(ctx.arithSingle());
		
		ASMAst operLeft = visit(ctx.arithSingle());
		ASMAst operRight = visit(ctx.operTDArithSingle().get(0).arithSingle());
		String operator = ctx.operTDArithSingle().get(0).oper.getText();

		List<ASMAst> l = new ArrayList<>();
		l.add(operLeft);
		l.add(operRight);
		l.add(POP(ID("B")));
		l.add(POP(ID("A")));
		l.add(operator.equals("*")?MUL(ID("B")): DIV(ID("B")));
		l.add(PUSH(ID("A")));
		ctx.operTDArithSingle().stream()
								.skip(1)
								.forEach(c->l.add(visit(c)));	
		return BLOCK(l);
		
 }
 
 
	@Override
   public ASMAst visitOperTDArithSingle(EightBitParser.OperTDArithSingleContext ctx){
		List<ASMAst> l = new ArrayList<>();
		l.add(visit(ctx.arithSingle()));
		l.add(POP(ID("B")));
		l.add(POP(ID("A")));
		l.add(ctx.oper.getText().equals("*")?MUL(ID("B")): DIV(ID("B")));
		l.add(PUSH(ID("A")));
		return BLOCK(l); 
   }

  @Override
  public ASMAst visitRelOperation(EightBitParser.RelOperationContext ctx){
    if(ctx.relOperator == null ){
      return visit(ctx.arithOperation(0));
    }
    List<ASMAst> chunk = new ArrayList<>();
    ASMAst loper = visit(ctx.arithOperation(0)); //visita la izquierda
    ASMAst roper = visit(ctx.arithOperation(1)); //visita la derecha
    ASMAst relOper = ID(jumps.get(ctx.relOperator.getText())); // obtiene el operador
    chunk.add(loper);
    chunk.add(roper);
    chunk.add(POP(ID("B")));
    chunk.add(POP(ID("A")));
    chunk.add(CMP(ID("A"),ID("B"))); //compare
    chunk.add(CJ(relOper,ID("out"))); //Conditional Jump
    return BLOCK(chunk);
   }

  @Override
  public ASMAst visitIfStatement(EightBitParser.IfStatementContext ctx){
     ArrayList<ASMAst> body = new ArrayList<>();
     body.add(ID("if:"));
     body.add(visit(ctx.expr()));
     body.add(visit(ctx.closedStatement(1)));
     body.add(JMP(ID("return")));
     body.add(ID("\nout:"));
     body.add(visit(ctx.closedStatement(0)));
     body.add(JMP(ID("return")));
     body.add(ID("\nreturn:"));
     return BLOCK(body);
  }

  @Override
  public ASMAst visitWhileStatement(EightBitParser.WhileStatementContext ctx){
		ArrayList<ASMAst> body = new ArrayList<>();
    body.add(ID("\nwhile:"));
    body.add(visit(ctx.expr()));
    body.add(visit(ctx.closedStatement()));
    body.add(JMP(ID("while")));
    body.add(ID("\nout:"));
    return BLOCK(body);
  }

   @Override
   public ASMAst visitArithIdSingle(EightBitParser.ArithIdSingleContext ctx){
		ASMId funName = ID(ctx.id().ID().getText());
		return ctx.arguments()==null ? visit(ctx.id()):
									ctx.arguments().args()==null? CALL(funName)
													: BLOCK( DATA(visit(ctx.arguments().args()), CALL(funName)));
   }

   	@Override
	public
	ASMAst visitArgs(EightBitParser.ArgsContext ctx){
		return BLOCK(ctx.expr().stream()
								.map( c -> visit(c) )
								.collect(Collectors.toList()));
	}


  @Override
  public ASMAst visitExprTrue(EightBitParser.ExprTrueContext ctx){
     return PUSH(ID("1"));
   }

   @Override
   public ASMAst visitExprFalse(EightBitParser.ExprFalseContext ctx){
      return PUSH(ID("0"));
    }

   @Override
   public ASMAst visitExprString(EightBitParser.ExprStringContext ctx){
		return PUSH( ID( this.simbolTable.addString(ctx.getText())));
   }
//
//
   @Override
   public ASMAst visitCallStatement(EightBitParser.CallStatementContext ctx) {
		ASMId funName = ID(ctx.ID().getText());
		ASMAst var = visit(ctx.arguments().args());

		return  BLOCK( DATA(var, CALL(funName)) );
   }


//--------------------------Metodo para generar el data area en base a los datos del simbolTable----------------//

	public List<ASMAst> genDataSegment(){
		List<ASMAst> l =new ArrayList<>();
		this.simbolTable.getFuns()
						.stream()
						.forEach((k)->l.addAll(DataSegmentFunction(k)));
		return l;
	}

	public List<ASMAst> DataSegmentFunction(String fun){
		List<ASMAst> l =new ArrayList<>();
		l.add(ID("\n."+fun+"_data:"));
		this.simbolTable.getVarFun(fun)
						.stream()
						.forEach((v)-> l.add( !v.getKey().contains("_String_") ? VAR(v.getValue())
																			:STRING(v.getKey(),v.getValue()))
								);
		if(!fun.equals("main"))
			l.add(VAR("."+fun+"_ra"));
		return l;
	}

//--------------------------Metodo para generar el prologo de una funcion

	public List<ASMAst> generateProlog(List<ASMAst> params){
		String[] reg = {"A","B","C"};
		Collections.reverse(params);//controlar que los parametros vienen invertidos en la pila
		ArrayList<ASMAst> prolog = new ArrayList<>();

		prolog.add(POP(ID("C")));
		params.stream().forEach(e -> prolog.add( POP( ID(reg[params.indexOf(e)]) )));
		params.stream().forEach(e-> prolog.add(PUSH(e)));

		prolog.add(PUSH(ID("[."+this.simbolTable.getFunActual()+"_ra]")));
		prolog.add(MOV( ID("[."+this.simbolTable.getFunActual()+"_ra]"), ID("C")));

		params.stream().forEach(e-> prolog.add(MOV(e,ID(reg[params.indexOf(e)]))));

		return prolog;
	}

//-----------------------Metodo para generar el ret final en base a identity.asm--------------


public List<ASMAst> generateRet(List<ASMAst> params){ //post sala
  String[] reg = {"A","B","C"};
  Collections.reverse(params);//controlar que los parametros vienen invertidos en la pila
  ArrayList<ASMAst> retu = new ArrayList<>();

  retu.add(POP(ID("A")));                                                   //pop A
  retu.add(MOV( ID("C") ,ID("[."+this.simbolTable.getFunActual()+"_ra]")));  //	MOV C, [f_ra]
  retu.add(POP(ID("B")));                                                   // 	POP B         ; restores previous ra
  retu.add(MOV( ID("[."+this.simbolTable.getFunActual()+"_ra]"), ID("B")));  //	MOV [f_ra], B                                                 //	POP B         ; restores previous n
  params.stream().forEach(e-> retu.add(MOV(e,ID(reg[params.indexOf(e)]))));
//    retu.add(MOV( ID('['+this.simbolTable.getFunActual()+"_ra]"), ID("B")));  //MOV [f_n], B
  retu.add(PUSH(ID("A")));                                                  //  PUSH A        ; pushes return value
  retu.add(PUSH(ID("C")));                                                  // 	PUSH C        ; pushes return address
  retu.add(RET());                                                          //	RET


  return retu;
}

public void generateJumps(){
  this.jumps.put(">","JBE");
  this.jumps.put(">=","JB");
  this.jumps.put("<","JAE");
  this.jumps.put("<=","JA");
  this.jumps.put("==","JNE");
  this.jumps.put("!=","JE");
}

}
