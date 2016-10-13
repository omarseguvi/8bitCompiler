package eightBit.js;
import java.io.*;

public interface JSAst{
   default void genCode(){
      genCode(System.out);
   }
   default void genCode(PrintStream out){
   }
}