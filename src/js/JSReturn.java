package eightBit.js;
import java.util.*;
import java.io.*;
public class JSReturn implements JSAst{
  
   private JSAst e;
   public JSReturn(JSAst e){
      this.e = e;
   }
   public void genCode(PrintStream out){
      out.print("return ");
	  this.e.genCode();
	  out.print(";");
   }
}