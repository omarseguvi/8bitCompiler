package eightBit.js;
import java.io.*;
public class ASMAtom<T> implements ASMAst{
   private T value;
   private boolean data;
   public T getValue(){return this.value;}

   public ASMAtom(T value){
      this.value = value;
   }
   public void genCode(PrintStream out){
      out.print(this.value);
   }
}
