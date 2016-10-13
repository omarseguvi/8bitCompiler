package eightBit.js;
import java.io.*;
public class JSAtom<T> implements JSAst{
   private T value;
   public T getValue(){return this.value;}
   
   public JSAtom(T value){
      this.value = value;
   }
   public void genCode(PrintStream out){
      out.print(this.value);
   }
}