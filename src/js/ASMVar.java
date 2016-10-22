package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMVar implements ASMAst{

  private String name;

  public ASMVar(String name){
	   this.name = name;
  }
  public void genCode(PrintStream out){
       out.format("\n\t%s: DB 0;", this.name);
   }
}
