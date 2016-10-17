package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMCFunction implements ASMAst{
   static private ASMId UNK = new ASMId("");
   private ASMId name;
   private List<ASMAst> instrucciones; //guardar los params de la funcion

   //podria guardar una lista con las instrucciones
   //Constructores
   public ASMCFunction(List<ASMAst> instrucciones){
     this(UNK, instrucciones);
   }

   public ASMCFunction(ASMId name, List<ASMAst> instrucciones){
     this.name = name;
     this.instrucciones = instrucciones;
   }

   public ASMCFunction(ASMId name){
     this.name = name;
     this.instrucciones = null;
   }

//Probar esto lo del out.format
   public void genCode(PrintStream out){
     out.format("%s:\n",this.name.getValue());
     if(this.instrucciones != null){
       this.instrucciones.stream()
                         .filter(f -> f != null)
                         .forEach( f -> {
                           ((ASMBlock)f).setName(this.name); //Le seteo el nombre para que la otra clase pueda imprimir fun_n: blabla
                           f.genCode(out);
                         });
     }
   }
}
