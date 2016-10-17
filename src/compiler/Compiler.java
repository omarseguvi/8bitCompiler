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
   public ASMAst getProgram(){
	   return this.program;
   }
   protected List<ASMAst> statements = new ArrayList<>();
   //Implementando el arbol de asm
   protected List<ASMAst> izquierda = new ArrayList<>();
   protected List<ASMAst> derecha = new ArrayList<>();

   public void genCode(){
      //this.statements.stream()
	                 //.forEach( t -> t.genCode());
      this.izquierda.stream().forEach( t -> t.genCode());
   }
   public ASMAst compile(ParseTree tree){
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
      //Dividir los datos en las dos listas TO DO
    //Hacer la clase ASMDFunction
    ASMId id = (ASMId)visit(ctx.id()); //id para el data
    ASMAst data = visit(ctx.formals());
    ASMAst vars = visit(ctx.funBody().letStatement());
    //Objetdo DFunction //falta sacar los let... y asi
    ASMAst dataFunction = DFUNCTION(id, DATA(data));
    this.izquierda.add(dataFunction);
    this.derecha.add(id);
    return id;
    //
    /*JSId id = (JSId)visit(ctx.id());
	  JSAst f = visit(ctx.formals());
	  JSAst body = visit(ctx.funBody());
	  JSAst function = FUNCTION(id, FORMALS(f), body);
	  this.statements.add(function);
	  return function;*/
   }
   /*@Override
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

   }*/

   @Override
   public ASMAst visitLetStatement(EightBitParser.LetStatementContext ctx){
     //Aqui es donde tenemos que meter en el nodo de la izquierda
     //las variables locales;

     EightBitParser.IdListContext idList = ctx.idList();
     ASMAst vars = (idList == null) ? BLOCK()
                                    : visit(idList);
     ASMAst valvars = ()
     System.out.println("llegando al let statement");
     return new ASMId("CACA");
   }

   @Override
   public ASMAst visitFormals(EightBitParser.FormalsContext ctx){
	   EightBitParser.IdListContext idList = ctx.idList();
	   return (idList == null ) ? BLOCK()
	                            : visit(idList);
   }
   @Override
   public ASMAst visitIdList(EightBitParser.IdListContext ctx){
	   return  BLOCK(ctx.id().stream()
						     .map( c -> visit(c))
						     .collect(Collectors.toList()));

   }
   @Override
   public ASMAst visitId(EightBitParser.IdContext ctx){
	  return  ID(ctx.ID().getText());
   }

   @Override
    public ASMAst visitArithOperation(EightBitParser.ArithOperationContext ctx) {
      //sacar el nombre del operador
     //String oper = ctx.oper.getType();
    // ASMNum p1 = (ASMNum)visit(ctx.arithMonom());
     //ASMNum p2 = (ASMNum)visit(ctx.arithMonom());

     if (ctx.oper == null)
		    return visit(ctx.arithMonom().get(0));
	   ASMAst oper = ( ctx.oper.getType() == EightBitParser.ADD ) ? ADD : MINUS;

     List<ASMAst> exprs = ctx.arithMonom().stream()
	                                        .map( c -> visit(c) )
										                      .collect(Collectors.toList());
	   return exprs.stream()
	               .skip(1)
				         .reduce(exprs.get(0), (opers, expr) ->
	                              OPERATION(oper, opers , expr));
    }

    @Override
    public ASMAst visitArithMonom(EightBitParser.ArithMonomContext ctx){
		ASMAst left = visit(ctx.arithSingle());
		return (ctx.operTDArithSingle() == null)
		       ? left
		       :ctx.operTDArithSingle().stream()
	                                   .map( c -> visit(c) )
									   .reduce(left, (opers, expr)
									                      -> FOLD_LEFT(opers , expr));
   }

   @Override
   public ASMAst visitOperTDArithSingle(EightBitParser.OperTDArithSingleContext ctx){
	   //System.err.println(" OperTDArithSingle " + ctx.getText() + ctx.oper);
	   ASMAst oper = ( ctx.oper.getType() == EightBitParser.MUL ) ? MUL : DIV;
	   ASMAst right = visit(ctx.arithSingle());
	   return OPERATION(oper, NULL, right);
   }
   @Override
   public ASMAst visitArithIdSingle(EightBitParser.ArithIdSingleContext ctx){
      return visit(ctx.id()); // ignoring by now arguments!!
   }
   @Override
   public ASMAst visitExprNum(EightBitParser.ExprNumContext ctx){
     //sacar los numeros
    ASMNum numero =  NUM(Integer.valueOf(ctx.NUMBER().getText()));
      this.derecha.add(numero);
      //System.out.println(((ASMNum)derecha.get(2)).getValue());
        return numero;
    //  return NUM(Double.valueOf(ctx.NUMBER().getText()));
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
