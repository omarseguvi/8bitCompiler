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
   private ASMTable simbolTable;

   public ASMAst getProgram(){
	   return this.program;
   }
   protected List<ASMAst> statements = new ArrayList<>();
   //Implementando el arbol de asm
   protected List<ASMAst> izquierda = new ArrayList<>();
   protected List<ASMAst> derecha = new ArrayList<>();

   public void genCode(){
      //Aqui se llamaria para que pinte el .init: Mov D, 232 JMP main
      System.out.print(".init:\n\tMOV D , 232\n\t.UNDEF:255\n\tJMP main\n"); //cambiar esto despues...
	    this.simbolTable.genCode();
      this.izquierda.stream().forEach( t -> t.genCode());
      this.derecha.stream().forEach(t -> t.genCode());
   }
   public ASMAst compile(ParseTree tree){
      this.a = 0;
	    this.simbolTable = new ASMTable();
      return visit(tree);
   }
   @Override
   public ASMAst visitEightProgram(EightBitParser.EightProgramContext ctx){
     ctx.eightFunction().stream()
	                      .forEach( fun -> visit(fun) );
	   return this.program = PROGRAM(this.statements);
   }
   @Override
   public ASMAst visitEightFunction(EightBitParser.EightFunctionContext ctx){
	    ASMId id= (ASMId)visit(ctx.id());
	     visit(ctx.formals());
	     visit(ctx.funBody());
    return null;
   }





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
   public ASMAst visitAssignStmtList(EightBitParser.AssignStmtListContext ctx) {
			ctx.assignStatement()
				.stream()
				.forEach(e->{this.simbolTable.addVar(e.id().ID().getText()); visit(e);});
			return this.simbolTable;
	}


   @Override
   public ASMAst visitId(EightBitParser.IdContext ctx){
	  //pregunta si el string es un id de una funcion o de una variable
	  return ctx.getParent() instanceof EightBitParser.EightFunctionContext ?
								ID( this.simbolTable.addFun(ctx.ID().getText())): visitVar(ctx);
   }

   public ASMAst visitVar(EightBitParser.IdContext ctx){
	   //pregunta si se esta declarando la variable o se esta utilizando
	  return isVarDeclaration(ctx) ?
		 ID(this.simbolTable.addVar(ctx.ID().getText())):ID('['+this.simbolTable.getPrimeVal(ctx.ID().getText())+']') ;
   }

   public Boolean isVarDeclaration(EightBitParser.IdContext ctx){
	   return ctx.getParent() instanceof EightBitParser.IdListContext ||
				ctx.getParent().getParent() instanceof EightBitParser.AssignStmtListContext;
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
	  visit(ctx.id());
	  return null;//OPERATION((ASMId)PUSH,, null);
   }
   @Override
   public ASMAst visitExprNum(EightBitParser.ExprNumContext ctx){
        return  ID(ctx.NUMBER().getText());
   }

   @Override
   public ASMAst visitExprString(EightBitParser.ExprStringContext ctx){
		return ID( this.simbolTable.addString(ctx.getText()) );
   }


   @Override
   public ASMAst visitCallStatement(EightBitParser.CallStatementContext ctx) {
		return visitChildren(ctx);
   }

}
