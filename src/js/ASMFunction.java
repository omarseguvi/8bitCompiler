package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMFunction implements ASMAst{

  private ASMId name;
  private ASMAst body; //Se guardan ASMOperation

  public ASMFunction(ASMId name){
	   this.name = name;
  }

  public ASMFunction(ASMId name,  ASMAst body){
    this.name = name;
    this.body = body;
  }

  public void genCode(PrintStream out){
       out.format("\n%s:", this.name.getValue());
	   if (this.body != null)
	       this.body.genCode(out);
      out.print("\n\t");
   }
}
