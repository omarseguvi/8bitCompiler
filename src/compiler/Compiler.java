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


public class Compiler extends EightBitBaseVisitor<JSAst> implements JSEmiter{
   protected JSAst program;
   public JSAst getProgram(){
	   return this.program;
   }
   protected List<JSAst> statements = new ArrayList<>();
   
   public void genCode(){
      this.statements.stream()
	                 .forEach( t -> t.genCode());
   }
   public JSAst compile(ParseTree tree){
      return visit(tree);
   }
   @Override
   public JSAst visitEightProgram(EightBitParser.EightProgramContext ctx){
	   ctx.eightFunction().stream()
	                      .forEach( fun -> visit(fun) );
	   return this.program = PROGRAM(this.statements);
   }
   @Override
   public JSAst visitEightFunction(EightBitParser.EightFunctionContext ctx){
      
      JSId id = (JSId)visit(ctx.id());
	  JSAst f = visit(ctx.formals());
	  JSAst body = visit(ctx.funBody());
	  JSAst function = FUNCTION(id, FORMALS(f), body);
	  this.statements.add(function);
	  return function;
   }
   @Override
   public JSAst visitEmptyStatement(EightBitParser.EmptyStatementContext ctx){
      return EMPTY();
	                
   }
   
   @Override
   public JSAst visitReturnStatement(EightBitParser.ReturnStatementContext ctx){
      return RET(visit(ctx.expr()));
	                
   }
   @Override
   public JSAst visitAssignStatement(EightBitParser.AssignStatementContext ctx){
	  return ASSIGN(visit(ctx.id()), visit(ctx.expr()));
	                
   }
   @Override
   public JSAst visitBlockStatement(EightBitParser.BlockStatementContext ctx){
	  EightBitParser.ClosedListContext closedList = ctx.closedList();
      return (closedList == null ) ? BLOCK() 
	                               : visit(closedList);
   }
   @Override
   public JSAst visitClosedList(EightBitParser.ClosedListContext ctx){					  
					   return  BLOCK(ctx.closedStatement().stream()
	                                                      .map( c -> visit(c))
										                  .collect(Collectors.toList()));
	                
   }
   @Override
   public JSAst visitFormals(EightBitParser.FormalsContext ctx){
	   EightBitParser.IdListContext idList = ctx.idList();
	   return (idList == null ) ? BLOCK()
	                            : visit(idList);
   }
   @Override
   public JSAst visitIdList(EightBitParser.IdListContext ctx){
	   return  BLOCK(ctx.id().stream()
						     .map( c -> visit(c))
						     .collect(Collectors.toList()));
	
   } 
   @Override
   public JSAst visitId(EightBitParser.IdContext ctx){
	  return  ID(ctx.ID().getText());
   }
   @Override
    public JSAst visitArithOperation(EightBitParser.ArithOperationContext ctx) {
	   if (ctx.oper == null)
		   return visit(ctx.arithMonom().get(0));
	   JSAst oper = ( ctx.oper.getType() == EightBitParser.ADD ) ? ADD : MINUS;
       List<JSAst> exprs = ctx.arithMonom().stream()
	                                       .map( c -> visit(c) )
										   .collect(Collectors.toList());
	   return exprs.stream()
	               .skip(1)
				   .reduce(exprs.get(0), (opers, expr) ->
	                              OPERATION(oper, opers , expr));
	   
    }
    @Override
    public JSAst visitArithMonom(EightBitParser.ArithMonomContext ctx){
		//System.err.println(" ArithMonom " + ctx.getText());
		JSAst left = visit(ctx.arithSingle());
		return (ctx.operTDArithSingle() == null) 
		       ? left
		       :ctx.operTDArithSingle().stream()
	                                   .map( c -> visit(c) )
									   .reduce(left, (opers, expr) 
									                      -> FOLD_LEFT(opers , expr));
   } 
   @Override
   public JSAst visitOperTDArithSingle(EightBitParser.OperTDArithSingleContext ctx){
	   //System.err.println(" OperTDArithSingle " + ctx.getText() + ctx.oper);
	   JSAst oper = ( ctx.oper.getType() == EightBitParser.MUL ) ? MUL : DIV;
	   JSAst right = visit(ctx.arithSingle());
	   return OPERATION(oper, NULL, right);
   }
   @Override
   public JSAst visitArithIdSingle(EightBitParser.ArithIdSingleContext ctx){
      return visit(ctx.id()); // ignoring by now arguments!!
   }
   @Override
   public JSAst visitExprNum(EightBitParser.ExprNumContext ctx){
      return NUM(Double.valueOf(ctx.NUMBER().getText()));
   }
   @Override
   public JSAst visitExprTrue(EightBitParser.ExprTrueContext ctx){
      return TRUE;
   }
   @Override
   public JSAst visitExprFalse(EightBitParser.ExprFalseContext ctx){
      return FALSE;
   }
   
}
  