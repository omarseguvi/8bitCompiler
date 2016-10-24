/*
Gabriel Andrés Moreno Leiter A00125558
Omar Segura Villegas 116110577
Andrey Campos Sánchez 504070843
Fabian Hernandez Chavarria 402270173
Carlos Artavia Pineda 116390735
*/

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
