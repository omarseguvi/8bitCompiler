package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMString implements ASMAst{

  private String name;
  private String value;

  public ASMString(String name, String value){
	   this.name = name;
	   this.value = value;
  }
  public void genCode(PrintStream out){
       out.format("\n\t%s: DB %s \n\tDB 0;", this.name, this.value);
   }
}
