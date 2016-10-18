package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMInstruction0 implements ASMAst{
   private String name;
   private ASMAst son;

   public ASMInstruction0(String name){
     this.name = name;
   }

//Probar esto lo del out.format
   public void genCode(PrintStream out){
		if(son.genCode()) son.genCode();
		son.genCode(out);
		out.println(name+";");
   }
}
