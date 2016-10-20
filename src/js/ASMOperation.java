package eightBit.js;
import java.io.*;
import java.util.*;


public class ASMOperation implements ASMAst{
  private ASMId  operator; //ver si lo cambio por un id
  private ASMId  loperand; //operador izquierdo
  private ASMId  roperand; //operador derecho
  private List<ASMAst>  children; //Operaciones de antesala ADD A, B    push 5 Pop b, PUSH 6 pOP A

public ASMOperation (ASMId operator, ASMId loperand, ASMId roperand, List<ASMAst> children){
  this.operator = operator;
  this.loperand = loperand; //operando izquierdo
  this.roperand = roperand; //operando derecho
  this.children = children; //anteSala
}

public void genCode(PrintStream out){
  if(children != null){
    children.stream().forEach(t -> t.genCode());
  }
  //validar si es dos parametros o de uno...
  out.print("\n\t"+this.operator.getValue()+" "+this.loperand.getValue()+";");
}

public String getOperator(){
  return this.operator.getValue();
}
}
