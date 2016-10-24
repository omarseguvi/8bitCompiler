/*
Gabriel Andrés Moreno Leiter A00125558
Omar Segura Villegas 116110577
Andrey Campos Sánchez 504070843
Fabian Hernandez Chavarria 402270173
Carlos Artavia Pineda 116390735
*/

package eightBit.compile;

import eightBit.js.*;
import java.util.*;

public interface ASMEmiter{


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
   default ASMPrint PRINTB(){
     return new ASMPrint(3);
   }

	default ASMId ID(String value){return new ASMId(value);}


	default ASMFunction FUNCTION(ASMId id, ASMAst body){
		 return new ASMFunction(id,body);
	}

	default ASMAst VAR(String name){return new ASMVar(name);}
	default ASMAst STRING(String name, String value){return new ASMString(name, value);}


   default List<ASMAst> DATA(ASMAst... args){ return Arrays.asList(args);}

//operaciones ASM
	default ASMAst CALL(ASMAst left){ return new ASMOperation(ID("CALL"), (ASMId)left ,null);}
	default ASMAst PUSH(ASMAst left){ return new ASMOperation(ID("PUSH"), (ASMId)left ,null);}
	default ASMAst POP (ASMAst left) { return new ASMOperation(ID("POP"),   (ASMId)left,null);}
	default ASMAst MOV (ASMAst left, ASMAst right){ return new ASMOperation(ID("MOV"), (ASMId)left,(ASMId)right);}
	default ASMAst CMP(ASMAst left, ASMAst right) { return new ASMOperation(ID("CMP"), (ASMId)left,(ASMId)right);}
	default ASMAst JMP (ASMId left)  {return new ASMOperation(ID("JMP") , left, null) ;};
	default ASMAst RET ()  {return new ASMOperation(ID("RET") , null,null) ;};
	default ASMAst HLT(){return new ASMOperation(ID("HLT"),null,null);};
	default ASMAst CJ(ASMAst oper, ASMAst left){ return new ASMOperation((ASMId)oper,(ASMId)left,null);}
	default ASMAst ADD(ASMAst left, ASMAst right) { return new ASMOperation(ID("ADD"), (ASMId)left,(ASMId)right);}
	default ASMAst SUB(ASMAst left, ASMAst right) { return new ASMOperation(ID("SUB"), (ASMId)left,(ASMId)right);}
	default ASMAst MUL (ASMId left)  {return new ASMOperation(ID("MUL") , left, null) ;};
	default ASMAst DIV (ASMId left)  {return new ASMOperation(ID("DIV") , left, null) ;};




}
