package eightBit.js;

import java.util.*;
import java.io.*;

public class ASMDFunction implements ASMAst{
   static private ASMId UNK = new ASMId("");
   private ASMId name;
   private List<ASMAst> data; //guardar los params de la funcion

   //podria guardar una lista con las instrucciones
   //Constructores
   public ASMDFunction(List<ASMAst> formals){
     this(UNK, formals);
   }

   public ASMDFunction(ASMId name, List<ASMAst> data){
     this.name = name;
     this.data = data;
   }

   public ASMDFunction(ASMId name){
     this.name = name;
     this.data = null;
   }

//Probar esto lo del out.format
   public void genCode(PrintStream out){
     out.format(".%s_data:\n",this.name.getValue());
     if(this.data != null){
       this.data.stream()
                   .filter(f -> f != null)
                   .forEach( f -> {
                     ((ASMBlock)f).setName(this.name); //Le seteo el nombre para que la otra clase pueda imprimir fun_n: blabla
                     f.genCode(out);
                   });

                  // out.print("\t"+this.name.getValue()+"_"+f.genCode(out)+": DB 0;");
                  //out.format("\t%s_%s: DB 0;",this.name.getValue(),((ASMId)f).getValue()
     }
   }
}
