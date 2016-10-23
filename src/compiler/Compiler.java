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
   protected List<ASMAst> codeArea = new ArrayList<>();

   public ASMAst getProgram(){
	   return this.program;
   }

   public void genCode(){

	  this.codeArea.stream().forEach(t -> t.genCode());
   }

   public ASMAst compile(ParseTree tree){
	  this.simbolTable = new SimbolTable();
      return visit(tree);
   }


   @Override
   public ASMAst visitEightProgram(EightBitParser.EightProgramContext ctx){
	   	codeArea.add( ID("\n.init:"));
		codeArea.add( MOV(ID("D"), ID("232")) );
		codeArea.add( JMP( ID("main")));
		codeArea.add( ID("\n\t.UNDEF: DB 255;"));

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

		if(id.getValue().equals("main"))
			 this.codeArea.add(PRINTS());

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
//
//
//   /*
//   @Override
//   public JSAst visitAssignStatement(EightBitParser.AssignStatementContext ctx){
//
//
//	  return Block( DATA(visit(ctx.expr()), POP(ID("A")), MOV( visit(ctx.id()), ID("A"))));
//
//   }
//   */

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
//
//  /* @Override
//   public ASMAst visitAssignStmtList(EightBitParser.AssignStmtListContext ctx) {
//			ctx.assignStatement()
//				.stream()
//				.forEach(e->{this.simbolTable.addVar(e.id().ID().getText()); visit(e);});
//			return ID("hola");
//	}
//   */
//
   @Override
   public ASMAst visitId(EightBitParser.IdContext ctx){
	  //pregunta si el string es un id de una funcion o de una variable
	  return ctx.getParent() instanceof EightBitParser.EightFunctionContext ?
								ID( this.simbolTable.addFun(ctx.ID().getText())): visitVar(ctx);
   }


   public ASMAst visitVar(EightBitParser.IdContext ctx){
	   //pregunta si se esta declarando la variable o se esta utilizando
	  return  isVarDeclaration(ctx) ? ID('['+this.simbolTable.addVar(ctx.ID().getText()) +']')
									 :PUSH (ID('['+this.simbolTable.getPrimeVal(ctx.ID().getText())+']'));

   }

   public Boolean isVarDeclaration(EightBitParser.IdContext ctx){
	   return ctx.getParent() instanceof EightBitParser.IdListContext ||
				ctx.getParent().getParent() instanceof EightBitParser.AssignStmtListContext;
   }
//
//   @Override
//    public ASMAst visitArithOperation(EightBitParser.ArithOperationContext ctx) {
//
//     if (ctx.oper == null)
//		    return visit(ctx.arithMonom().get(0));
//
//     ASMAst oper = ( ctx.oper.getType() == EightBitParser.ADD ) ? ADD : MINUS;
//
//     List<ASMAst> exprs = ctx.arithMonom().stream()
//	                                        .map( c -> visit(c) )
//										                      .collect(Collectors.toList());
//
//     return ID("prueba");
//	  /* return exprs.stream()
//	               .skip(1)
//				         .reduce(exprs.get(0), (opers, expr) ->
//	                              OPERATION((ASMId)oper, opers , expr));*/
//    }
//
//    @Override
//    public ASMAst visitArithMonom(EightBitParser.ArithMonomContext ctx){
//		ASMAst left = visit(ctx.arithSingle());
//
//    if(ctx.operTDArithSingle() == null){
//      return ID("Probando");
//      /*if(this.a == 0){
//        this.a = 1;
//        return OPERATION((ASMId)POPA, left, null);
//      }
//      else{
//        this.a = 0;
//        return OPERATION((ASMId)POPB, left, null);
//      }*/
//    }
//    else
//      return ctx.operTDArithSingle()
//                .stream()
//                .map( c -> visit(c) )
//                .reduce(left,(opers, expr)->FOLD_LEFT(opers , expr));
///*
//    return (ctx.operTDArithSingle() == null)
//		       ? left
//		       : ctx.operTDArithSingle()
//                .stream()
//	              .map( c -> visit(c) )
//						    .reduce(left,(opers, expr)->FOLD_LEFT(opers , expr));*/
//   }
///*
//   @Override
//   public ASMAst visitArithSingle(EightBitParser.ArithIdSingleContext ctx){
//     return OPERATION((ASMId)PUSH,visit(ctx.id()), null);
//   }*/
//   @Override
//   public ASMAst visitOperTDArithSingle(EightBitParser.OperTDArithSingleContext ctx){
//	   //System.err.println(" OperTDArithSingle " + ctx.getText() + ctx.oper);
//	   ASMAst oper = ( ctx.oper.getType() == EightBitParser.MUL ) ? MUL : DIV;
//	   ASMAst right = visit(ctx.arithSingle());
//	   //return OPERATION((ASMId)oper, NULL, right);
//     return new ASMId("Por el momento nada");
//   }
   @Override
   public ASMAst visitArithIdSingle(EightBitParser.ArithIdSingleContext ctx){
		ASMId funName = ID(ctx.id().ID().getText());
		return ctx.arguments()==null ? visit(ctx.id()): BLOCK( DATA(visit(ctx.arguments()), CALL(funName)));
   }


//   @Override
//   public ASMAst visitExprNum(EightBitParser.ExprNumContext ctx){
//        return  ID(ctx.NUMBER().getText());
//   }
//
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
		ArrayList<ASMAst> prolog = new ArrayList<>();

		prolog.add(POP(ID("C")));
		params.stream().forEach(e -> prolog.add( POP( ID(reg[params.indexOf(e)]) )));
		params.stream().forEach(e-> prolog.add(PUSH(e)));

		prolog.add(PUSH(ID("[."+this.simbolTable.getFunActual()+"_ra]")));
		prolog.add(MOV( ID("[."+this.simbolTable.getFunActual()+"_ra]"), ID("C")));

		params.stream().forEach(e-> prolog.add(MOV(e,ID(reg[params.indexOf(e)]))));

		return prolog;
	}

//-----------------------Metodo para saber si una funcion retorna algo--------------


public List<ASMAst> generateRet(List<ASMAst> params){ //post sala
  String[] reg = {"A","B","C"};
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



}
