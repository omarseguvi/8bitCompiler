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

public class SimbolTable {
 HashMap<String, HashMap<String,String>> simbolos;
 HashMap<String, HashMap<String,String>> simbolosString;
 String funActual;
 int stringCounter;

 public SimbolTable(){
   simbolos = new HashMap<String, HashMap<String, String>>();
   stringCounter=0;
 }

 public void setFunActual(String name){
   this.funActual = name;
 }


 public String getFunActual(){
   return this.funActual;
 }

 public String addFun(String key){
   HashMap<String,String> nuevo = new HashMap<>();
   simbolos.put(key,nuevo);
   setFunActual(key);
   return key;
 }

 public String addVar(String var){
   String convert = "."+this.funActual+"_"+var;
   simbolos.get(this.funActual).put(var,convert);
   return convert;
 }

 public String getPrimeVal(String val){
   String ret = simbolos.get(this.funActual).get(val);
   if(ret==null) throw new RuntimeException("Variable "+val+" no declarada dentro de contexto");
   return ret;
 }

 public String addString(String content){
         String convert =  "."+this.funActual+"_String_"+ (++stringCounter);
         simbolos.get(this.funActual).put( convert  ,content);
	 return convert;
 }

 public boolean exists(String funName){
   return simbolos.containsKey(funName); //después hacer el RuntimeException
 }

 public Set<String> getFuns(){
	 return this.simbolos.keySet();
 }

  public Set<Map.Entry<String,String>> getVarFun(String fun){
	 return this.simbolos.get(fun).entrySet();
 }

  public void genCode(PrintStream out){
	 simbolos.forEach((k,v)->{out.print("\n."+k +"_data: "); genVariables(v,out);});
  }

  public void genVariables( HashMap<String, String> values, PrintStream out){
	  //pregunta si la variable es un string , para saber como imprimirlo en 8bit assembler .
	  values.forEach((k,v)->out.print( ((String)k).matches(".*_String_.*") ? "\n\t"+k+ ": DB "+ v +"\n\t\t\tDB 0;"
										:"\n\t"+v+": DB 0;"));
  }


}
