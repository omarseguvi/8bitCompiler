package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMInstruction2 implements ASMAst{
   private String name;
   private ASMAst param1;
   private ASMAst param2;
   private ASMAst son;

   public ASMInstruction2(String name){
     this.name = name;
   }

//Probar esto lo del out.format
   public void genCode(PrintStream out){
		if(son.genCode()) son.genCode();
		son.genCode();
		out.println(name+";");
   }
}
