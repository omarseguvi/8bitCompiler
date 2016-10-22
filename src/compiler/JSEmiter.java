package eightBit.compile;

import eightBit.js.*;
import java.util.*;

public interface JSEmiter{


   default ASMAst PROGRAM(List<ASMAst> functions){ return new ASMProgram(functions);}

   default ASMAst BLOCK(List<ASMAst> members){ return new ASMBlock(members);}

   default ASMAst BLOCK(){ return new ASMBlock(Arrays.asList());}
   
   //opcion de mezclar bloques
   default ASMAst JoinBlock(ASMAst b1,ASMAst b2){ 
			List<ASMAst> members = new ArrayList<>();
			members.addAll(((ASMBlock) b1).getMembers());
			members.addAll( ((ASMBlock) b2).getMembers());
			return new ASMBlock(members); 
   }
   
   default ASMPrint PRINTS(){
     return new ASMPrint(1);
   }
   default ASMPrint PRINTN(){
     return new ASMPrint(2);
   }

	default ASMId ID(String value){return new ASMId(value);}


	default ASMFunction FUNCTION(ASMId id, ASMAst body){
		 return new ASMFunction(id,body);
	}
	
	default ASMAst VAR(String name){return new ASMVar(name);}
	default ASMAst STRING(String name, String value){return new ASMString(name, value);}
	

//  /*
//   default JSIf IF(JSAst c, JSAst t, JSAst e){
//       return new JSIf(c, e, t);
//   }
//
//   default JSCall CALL(JSAst f, List<JSAst> args){
//       return new JSCall(f, args);
//   }*/
//   default ASMOperation OPERATION(ASMId oper, ASMId left, ASMId right, List<ASMAst> children){
//     return new ASMOperation(oper, left, right, children);
//   }
//   default ASMAst FOLD_LEFT(ASMAst left, ASMAst right){
//	   // Expected right = OPERATION(oper, null, r)
//	   //JSOperation rightOperation = (JSOperation)right;
//	   // Returns OPERATION(oper, left, r)
//	   //return new JSOperation(rightOperation.getOper(), left, rightOperation.getRight());
//     return new ASMId("ca");
//   }
//   /*
//   default JSAst ASSIGN(JSAst left, JSAst right){
//	   return new JSAssign(left, right);
//   }
//   default List<JSAst> ARGS(List<JSAst>  args){ return args;}
//   //default List<JSAst> ARGS(JSAst... args){ return Arrays.asList(args);}
//*/
   default List<ASMAst> DATA(ASMAst... args){ return Arrays.asList(args);}
 
//operaciones ASM  
	default ASMAst CALL(ASMAst left){ return new ASMOperation(ID("CALL"), (ASMId)left ,null);}
	default ASMAst PUSH(ASMAst left){ return new ASMOperation(ID("PUSH"), (ASMId)left ,null);}
	default ASMAst POP (ASMAst left) { return new ASMOperation(ID("POP"),   (ASMId)left,null);}
	default ASMAst MOV (ASMAst left, ASMAst right){ return new ASMOperation(ID("MOV"), (ASMId)left,(ASMId)right);}
	default ASMAst CMP(ASMAst left, ASMAst right) { return new ASMOperation(ID("CMP"), (ASMId)left,(ASMId)right);}
	default ASMAst JMP (ASMId left)  {return new ASMOperation(ID("JMP") , left, null) ;};

	//   
////funcion para el data
//	default ASMAst SET_PARAM(String param){
//		return MOV(ID(param), ID("A"), DATA(POP(ID("A"),null)) );
//	}
//
//  final ASMAst POPA = new ASMId("POP A");
//  final ASMAst POPB = new ASMId("POP B");
//  final ASMAst POP = new ASMId("POP ");
//  final ASMAst PUSHA = new ASMId("PUSH A");
//  final ASMAst PUSHB = new ASMId("PUSH B");
//  final ASMAst PUSH =  new ASMId("PUSH ");
//  final ASMAst ADD = new ASMId("ADD A, B");
//  final ASMAst MINUS = new ASMId("SUB A, B");
//  final ASMAst MUL = new ASMId("MUL B");
//  final ASMAst DIV = new ASMId("DIV B");
//  final ASMAst CALL = new ASMId("CALL ");
//  final ASMAst NULL = new ASMId("null");
//  final ASMAst RET = new ASMId("RET");
//  final ASMAst HLT = new ASMId("HLT");

}
