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
   private int a;
   public ASMAst getProgram(){
	   return this.program;
   }
   protected List<ASMAst> statements = new ArrayList<>();
   
   //Implementando el arbol de asm
   protected List<ASMAst> izquierda = new ArrayList<>();
   protected List<ASMAst> derecha = new ArrayList<>();

   public void genCode(){
      //Aqui se llamaria para que pinte el .init: Mov D, 232 JMP main
      System.out.print(".init:\n\tMOV D , 232\n\tJMP main\n"); //cambiar esto despues...
      this.izquierda.stream().forEach( t -> t.genCode());
      this.derecha.stream().forEach(t -> t.genCode());
   }
   public ASMAst compile(ParseTree tree){
      this.a = 0;
      return visit(tree);
   }
   @Override
   public ASMAst visitEightProgram(EightBitParser.EightProgramContext ctx){
     //System.out.println("llegando al program");
     ctx.eightFunction().stream()
	                      .forEach( fun -> visit(fun) );
	   return this.program = PROGRAM(this.statements);
   }
   @Override
   public ASMAst visitEightFunction(EightBitParser.EightFunctionContext ctx){
	
    ASMId id_fun = new IDFunData(ctx.id().ID().getText()); //id para el data
    this.izquierda.add(id_fun);
	ASMAst data = visit(ctx.formals());
	this.izquierda.add(data);
	
    EightBitParser.LetStatementContext letStatement = ctx.funBody().letStatement();
    ASMAst dataFunction;
   

/*   
   if(letStatement != null){
      ASMAst vars = visit(letStatement.assignStmtList());
       dataFunction = DFUNCTION(id, DATA(BLOCK(((ASMBlock)data).getMembers(),((ASMBlock)vars).getMembers())));
    }
    else
      dataFunction = DFUNCTION(id,DATA(BLOCK(((ASMBlock)data).getMembers())));
    this.izquierda.add(dataFunction);

     /// Aqui seguiria lo de la derecha
    ASMAst code = visit(ctx.funBody().letStatement().closedStatement()); //despues hacer validacion
    ASMAst codeFunction = CFUNCTION(id, DATA(CBLOCK(((ASMCBlock)code).getMembers())));
    this.derecha.add(codeFunction);
	*/

    return null;
   }

   /*@Override
   public JSAst visitEmptyStatement(EightBitParser.EmptyStatementContext ctx){
      return EMPTY();

   }
*/
   @Override
   public ASMAst visitReturnStatement(EightBitParser.ReturnStatementContext ctx){
     ASMAst expr = visit(ctx.expr());
     return expr;
     //ASMAst ret = OPERATION( RET, null, null); despues ponerlo porque de algun modo hay que agregarlo al final
   }
   /*
   @Override
   public JSAst visitAssignStatement(EightBitParser.AssignStatementContext ctx){
	  return ASSIGN(visit(ctx.id()), visit(ctx.expr()));

   }
   */

   @Override
   public ASMAst visitBlockStatement(EightBitParser.BlockStatementContext ctx){
      EightBitParser.ClosedListContext closedList = ctx.closedList();
      return (closedList == null ) ? CBLOCK()
	                                 : visit(closedList);
   }

   @Override
   public ASMAst visitClosedList(EightBitParser.ClosedListContext ctx){
					   return  CBLOCK(ctx.closedStatement()
                              .stream()
	                            .map( c -> visit(c))
						                  .collect(Collectors.toList()));

   }

   @Override
   public ASMAst visitLetStatement(EightBitParser.LetStatementContext ctx){
     //Tengo que traerme una lista con todos los objetos ASMVar
     EightBitParser.AssignStmtListContext assignList = ctx.assignStmtList();
     return (assignList == null) ? BLOCK()
                                 : visit(assignList);
   }


   @Override
   public ASMAst visitAssignStmtList(EightBitParser.AssignStmtListContext ctx){
     return null;
   }

   @Override
   public ASMAst visitFormals(EightBitParser.FormalsContext ctx){
	   EightBitParser.IdListContext idList = ctx.idList();
	   return (idList == null ) ? null
	                            : visit(idList);
   }
   @Override
   public ASMAst visitIdList(EightBitParser.IdListContext ctx){
	   return  	ctx.id().stream()
					     .map( c -> new ASMVar(c.ID().getText()))
					     .collect(Collectors.toList());

   }
   @Override
   public ASMAst visitId(EightBitParser.IdContext ctx){
	  return ID(ctx.ID().getText());
   }

   @Override
    public ASMAst visitArithOperation(EightBitParser.ArithOperationContext ctx) {

     if (ctx.oper == null)
		    return visit(ctx.arithMonom().get(0));

     ASMAst oper = ( ctx.oper.getType() == EightBitParser.ADD ) ? ADD : MINUS;

     List<ASMAst> exprs = ctx.arithMonom().stream()
	                                        .map( c -> visit(c) )
										                      .collect(Collectors.toList());

	   return exprs.stream()
	               .skip(1)
				         .reduce(exprs.get(0), (opers, expr) ->
	                              OPERATION((ASMId)oper, opers , expr));
    }

    @Override
    public ASMAst visitArithMonom(EightBitParser.ArithMonomContext ctx){
		ASMAst left = visit(ctx.arithSingle());

    if(ctx.operTDArithSingle() == null){
      if(this.a == 0){
        this.a = 1;
        return OPERATION((ASMId)POPA, left, null);
      }
      else{
        this.a = 0;
        return OPERATION((ASMId)POPB, left, null);
      }
    }
    else
      return ctx.operTDArithSingle()
                .stream()
                .map( c -> visit(c) )
                .reduce(left,(opers, expr)->FOLD_LEFT(opers , expr));
/*
    return (ctx.operTDArithSingle() == null)
		       ? left
		       : ctx.operTDArithSingle()
                .stream()
	              .map( c -> visit(c) )
						    .reduce(left,(opers, expr)->FOLD_LEFT(opers , expr));*/
   }
/*
   @Override
   public ASMAst visitArithSingle(EightBitParser.ArithIdSingleContext ctx){
     return OPERATION((ASMId)PUSH,visit(ctx.id()), null);
   }*/
   @Override
   public ASMAst visitOperTDArithSingle(EightBitParser.OperTDArithSingleContext ctx){
	   //System.err.println(" OperTDArithSingle " + ctx.getText() + ctx.oper);
	   ASMAst oper = ( ctx.oper.getType() == EightBitParser.MUL ) ? MUL : DIV;
	   ASMAst right = visit(ctx.arithSingle());
	   return OPERATION((ASMId)oper, NULL, right);
   }
   @Override
   public ASMAst visitArithIdSingle(EightBitParser.ArithIdSingleContext ctx){
      return OPERATION((ASMId)PUSH,visit(ctx.id()), null);
      //return visit(ctx.id()); // ignoring by now arguments!!
   }
   @Override
   public ASMAst visitExprNum(EightBitParser.ExprNumContext ctx){
        return  ID(ctx.NUMBER().getText());
    //return NUM(Integer.valueOf(ctx.NUMBER().getText())); Esto lo hago por el momento
   }

   @Override
   public ASMAst visitExprString(EightBitParser.ExprStringContext ctx){
     return ID(ctx.STRING().getText()); //esto para que le ponga las comillas a los string :D
   }
   /*
   @Override
   public JSAst visitExprTrue(EightBitParser.ExprTrueContext ctx){
      return TRUE;
   }
   @Override
   public JSAst visitExprFalse(EightBitParser.ExprFalseContext ctx){
      return FALSE;
   }
*/
}
