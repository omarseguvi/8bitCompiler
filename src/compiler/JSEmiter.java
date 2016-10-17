package eightBit.compile;

import eightBit.js.*;
import java.util.*;

public interface JSEmiter{
   default ASMAst PROGRAM(List<ASMAst> functions){ return new ASMProgram(functions);}
   //Block -> para data
   //CBlock -> para codigo
   default ASMAst BLOCK(List<ASMAst> members){ return new ASMBlock(members);}
   default ASMAst BLOCK(List<ASMAst> members, List<ASMAst> vars){
     return new ASMBlock(members,vars);
   }
   default ASMAst BLOCK(){ return new ASMBlock(Arrays.asList());}

   default ASMAst CBLOCK(List<ASMAst> members){
     return new ASMCBlock(members);
   }
   default ASMAst CBLOCK(){
     return new ASMCBlock(Arrays.asList());
   }

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

   default ASMCFunction CFUNCTION(ASMId id, List<ASMAst> code){
     return new ASMCFunction(id,code);
   }
   default ASMCFunction CFUNCTION(ASMId id){
     return new ASMCFunction(id);
   }

/*
   default JSIf IF(JSAst c, JSAst t, JSAst e){
       return new JSIf(c, e, t);
   }

   default JSCall CALL(JSAst f, List<JSAst> args){
       return new JSCall(f, args);
   }*/
   default ASMOperation OPERATION(ASMId oper, ASMAst left, ASMAst right){
     return new ASMOperation(oper, left, right);
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

  final ASMAst POPA = new ASMId("POP A");
  final ASMAst POPB = new ASMId("POP B");
  final ASMAst POP = new ASMId("POP ");
  final ASMAst PUSHA = new ASMId("PUSH A");
  final ASMAst PUSHB = new ASMId("PUSH B");
  final ASMAst PUSH =  new ASMId("PUSH ");
  final ASMAst ADD = new ASMId("ADD A, B");
  final ASMAst MINUS = new ASMId("SUB A, B");
  final ASMAst MUL = new ASMId("MUL B");
  final ASMAst DIV = new ASMId("DIV B");
  final ASMAst CALL = new ASMId("CALL ");
  final ASMAst NULL = new ASMId("null");
  final ASMAst RET = new ASMId("RET");
  final ASMAst HLT = new ASMId("HLT");

}
