package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMFunction implements ASMAst{

   private ASMId name;
   private ASMAst body;
    
   public ASMFunction(ASMId name){
	  this.name = name;
   }
   
   public void genCode(PrintStream out){
       out.format("%s:", this.name.getValue());
	   if (this.body != null)
	      this.body.genCode(out);
	   out.print("RET");
   }
}