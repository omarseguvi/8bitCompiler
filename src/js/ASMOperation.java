package eightBit.js;
import java.io.*;


public class ASMOperation implements ASMAst{
  private ASMId  operator; //ver si lo cambio por un id
  private ASMAst  loperand; //operador izquierdo
  private ASMAst  roperand; //operador derecho

public ASMOperation (ASMId operator,ASMAst loperand, ASMAst roperand){
  this.operator = operator;
  this.loperand = loperand; //operando izquierdo
  this.roperand = roperand; //operando derecho
}

public void genCode(PrintStream out){
  if(loperand != null && roperand != null ){
    //out.println(operator);
  }
  else if(roperand != null ){
    //out.println(operator + " " + loperand);
  }
  else{
    operator.genCode(out);
    out.print(" ");
    loperand.genCode(out);
    out.print(", ");
    roperand.genCode(out);
  }
}

public String getOperator(){
  return this.operator.getValue();
}
}
