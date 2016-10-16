package eightBit.js;
import java.io.*;
public class ASMVar implements ASMAst{
   private String value;
   public String getValue(){return this.value;}
   
   public ASMVar(String value){
      this.value = value;
   }
   
   public void genCode(PrintStream out){
      out.print(this.value);
   }
}