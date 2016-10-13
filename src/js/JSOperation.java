package eightBit.js;
import java.io.*;
public class JSOperation implements  JSAst{
   private JSAst oper;
   private JSAst left, right;
   public JSAst getOper(){return this.oper;}
   public JSAst getLeft(){return this.left;}
   public JSAst getRight(){return this.right;}
   public JSOperation(JSAst oper, JSAst left, JSAst right){
      this.oper = oper;
	  this.left = left;
	  this.right = right;
   }
   public void genCode(PrintStream out){
      left.genCode(out);
	  oper.genCode(out);
	  right.genCode(out);
   }
}