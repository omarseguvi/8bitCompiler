package eightBit.js;
import java.io.*;
public class ASMVar implements ASMAst{
   private ASMId name;

   public ASMVar(ASMId name){
      this.name = name;
   }

   public void genCode(PrintStream out){
	  this.name.genCode(out);
      out.println(": DB 0;");
   }
}
