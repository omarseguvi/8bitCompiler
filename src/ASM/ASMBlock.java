/*
Gabriel Andrés Moreno Leiter A00125558
Omar Segura Villegas 116110577
Andrey Campos Sánchez 504070843
Fabian Hernandez Chavarria 402270173
Carlos Artavia Pineda 116390735
*/

package eightBit.js;
import java.util.*;
import java.io.*;
public class ASMBlock implements ASMAst{
   protected List<ASMAst> members;

   public List<ASMAst> getMembers(){
	   return this.members;
   }

   public ASMBlock(List<ASMAst> members){
     this.members = members;
   }

   public void genCode(PrintStream out){
       this.members.stream().filter(t -> t != null)
	                          .forEach( t -> t.genCode());
   }

}
