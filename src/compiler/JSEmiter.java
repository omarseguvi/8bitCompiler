package eightBit.compile;

import eightBit.js.*;
import java.util.*;

public interface JSEmiter{
   default ASMAst PROGRAM(List<ASMAst> functions){ return new ASMProgram(functions);}

   default ASMAst BLOCK(List<ASMAst> members){ return new ASMBlock(members);}
   default ASMAst BLOCK(List<ASMAst> members, List<ASMAst> vars){
     return new ASMBlock(members,vars);
   }
   default ASMAst BLOCK(){ return new ASMBlock(Arrays.asList());}

   /*default JSAst EMPTY(){
	   return new JSEmpty();
   }*/

   default ASMId ID(String value){return new ASMId(value);}

   default ASMVar VAR(ASMId name, ASMId value){
     return new ASMVar(name,value);
   }

   default ASMNum NUM(int value){ return new ASMNum(value);}

   default ASMDFunction DFUNCTION(ASMId id, List<ASMAst> data){
     return new ASMDFunction(id,data);
   }
   default ASMDFunction DFUNCTION(ASMId id){
     return new ASMDFunction(id);
   }
   //default JSId  ID(String value){return new JSId(value);}

   /*default JFunction FUNCTION(JSId id, List<JSAst> formals, JSAst body){
      return new JSFunction(id, formals, body);
   }

/*
   default JSIf IF(JSAst c, JSAst t, JSAst e){
       return new JSIf(c, e, t);
   }

   default JSCall CALL(JSAst f, List<JSAst> args){
       return new JSCall(f, args);
   }*/
   default ASMAst OPERATION(ASMAst oper, ASMAst left, ASMAst right){
     return new ASMOperation(((ASMId)oper).getValue(), left, right);
   }
   default ASMAst FOLD_LEFT(ASMAst left, ASMAst right){
	   // Expected right = OPERATION(oper, null, r)
	   //JSOperation rightOperation = (JSOperation)right;
	   // Returns OPERATION(oper, left, r)
	   //return new JSOperation(rightOperation.getOper(), left, rightOperation.getRight());
     return new ASMId("ca");
   }
   /*
   default JSAst ASSIGN(JSAst left, JSAst right){
	   return new JSAssign(left, right);
   }
   default List<JSAst> ARGS(List<JSAst>  args){ return args;}
   //default List<JSAst> ARGS(JSAst... args){ return Arrays.asList(args);}
*/
   default List<ASMAst> DATA(ASMAst... args){ return Arrays.asList(args);}
/*
   default JSAst RET(JSAst e){ return new JSReturn(e);}
   default JSAst OPER(String op){return new JSId(op);}
   final JSBool TRUE = new JSBool(true);
   final JSBool FALSE = new JSBool(false);
   final JSAst ADD = new JSId("+");
   final JSAst MINUS = new JSId("-");
   final JSAst MUL = new JSId("*");
   final JSAst DIV = new JSId("/");
   final JSAst NULL = new JSId("null");

*/
  final ASMAst ADD = new ASMId("ADD");
  final ASMAst MINUS = new ASMId("SUB");
  final ASMAst MUL = new ASMId("MUL");
  final ASMAst DIV = new ASMId("DIV");
  final ASMAst NULL = new ASMId("null");

}
