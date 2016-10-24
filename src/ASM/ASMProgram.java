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
public class ASMProgram implements ASMAst{
   static private ASMId UNK = new ASMId("");
   private ASMId name;
   private List<ASMAst> functions;
   private ASMAst body;
   public ASMProgram(List<ASMAst> functions){
      this(UNK, functions);
   }
   public ASMProgram(ASMId name, List<ASMAst> functions){
      this.functions = functions;
	    this.name = name;
   }
   public void genCode(PrintStream out){
       functions.stream().forEach( t -> t.genCode(out));
   }
}
