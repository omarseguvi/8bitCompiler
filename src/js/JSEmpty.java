package eightBit.js;
import java.util.*;
import java.io.*;
	
public class JSEmpty implements JSAst{
   @Override
   public void genCode(PrintStream out){
	   out.println("/* empty statement! */");
   }
}