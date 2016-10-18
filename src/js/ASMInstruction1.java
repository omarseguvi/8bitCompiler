package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMInstruction1 implements ASMAst{
   private String name;
   private ASMAst param1;
   private ASMAst son;
   

   public ASMInstruction1(String name, ASMAst param1){
     this.name = name;
	 this.param1 = param1;
   }

//Probar esto lo del out.format
   public void genCode(PrintStream out){
		if(son.genCode()) son.genCode();
		out.print(name);
		param1.genCode();
		out.println(";");
   }
}
