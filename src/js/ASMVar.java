package eightBit.js;
import java.io.*;
public class ASMVar implements ASMAst{
   private ASMId value;
   private ASMId name;

   public ASMVar(ASMId name, ASMId value){
      this.value = value;
      this.name = name;
   }

   public String getValue(){
     return value.getValue();
   }

   public String getName(){
     return name.getValue();
   }

   public void genCode(PrintStream out){
      out.print(this.value);
   }
}
