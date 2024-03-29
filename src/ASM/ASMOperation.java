/*
Gabriel Andrés Moreno Leiter A00125558
Omar Segura Villegas 116110577
Andrey Campos Sánchez 504070843
Fabian Hernandez Chavarria 402270173
Carlos Artavia Pineda 116390735
*/

package eightBit.js;
import java.io.*;
import java.util.*;


public class ASMOperation implements ASMAst{
  private ASMId  operator; //ver si lo cambio por un id
  private ASMId  loperand; //operador izquierdo
  private ASMId  roperand; //operador derecho

public ASMOperation (ASMId operator, ASMId loperand, ASMId roperand){
  this.operator = operator;
  this.loperand = loperand; //operando izquierdo
  this.roperand = roperand; //operando derecho
}

public void genCode(PrintStream out){
  out.print("\n\t"+this.operator.getValue());
  out.print(this.loperand==null?";": (" "+this.loperand.getValue() +
			(this.roperand==null? ";": ','+this.roperand.getValue()+";" )));
}

public String getOperator(){
  return this.operator.getValue();
}

}
