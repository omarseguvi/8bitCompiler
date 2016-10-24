/*
Gabriel Andrés Moreno Leiter A00125558
Omar Segura Villegas 116110577
Andrey Campos Sánchez 504070843
Fabian Hernandez Chavarria 402270173
Carlos Artavia Pineda 116390735
*/

package eightBit.js;
import java.io.*;

public interface ASMAst{
   default void genCode(){
      genCode(System.out);
   }
   default void genCode(PrintStream out){
   }
}
