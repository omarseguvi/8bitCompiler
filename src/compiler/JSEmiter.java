package eightBit.compile;

import eightBit.js.*;
import java.util.*;

public interface JSEmiter{	
   default JSAst PROGRAM(List<JSAst> functions){ return new JSProgram(functions);} 
   
   default JSAst BLOCK(List<JSAst> members){ return new JSBlock(members);}
   default JSAst BLOCK(){ return new JSBlock(Arrays.asList());}
   
   default JSAst EMPTY(){
	   return new JSEmpty();
   }
   
   default JSNum NUM(double value){ return new JSNum(value);}
   
   default JSId  ID(String value){return new JSId(value);}
   
   default JSFunction FUNCTION(JSId id, List<JSAst> formals, JSAst body){
           return new JSFunction(id, formals, body);
   }
   
   
   default JSIf IF(JSAst c, JSAst t, JSAst e){
       return new JSIf(c, e, t);
   }
   
   default JSCall CALL(JSAst f, List<JSAst> args){
       return new JSCall(f, args);
   }
   default JSAst OPERATION(JSAst oper, JSAst left, JSAst right){
	   return new JSOperation(oper, left, right);
   }
   default JSAst FOLD_LEFT(JSAst left, JSAst right){
	   // Expected right = OPERATION(oper, null, r)
	   JSOperation rightOperation = (JSOperation)right;
	   // Returns OPERATION(oper, left, r)
	   return new JSOperation(rightOperation.getOper(), left, rightOperation.getRight());
   }
   default JSAst ASSIGN(JSAst left, JSAst right){
	   return new JSAssign(left, right);
   }
   default List<JSAst> ARGS(List<JSAst>  args){ return args;}
   //default List<JSAst> ARGS(JSAst... args){ return Arrays.asList(args);}
   default List<JSAst> FORMALS(JSAst... args){ return Arrays.asList(args);}
   
   
   default JSAst RET(JSAst e){ return new JSReturn(e);}
   default JSAst OPER(String op){return new JSId(op);}
   final JSBool TRUE = new JSBool(true);
   final JSBool FALSE = new JSBool(false);
   final JSAst ADD = new JSId("+");
   final JSAst MINUS = new JSId("-");
   final JSAst MUL = new JSId("*");
   final JSAst DIV = new JSId("/");
   final JSAst NULL = new JSId("null");
   
   
   
}