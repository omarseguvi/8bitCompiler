package eightBit.js;
import java.util.*;
import java.io.*;
public class JSBlock implements JSAst {
   protected List<JSAst> members;
   public List<JSAst> getMembers(){
	   return this.members;
   }
   public JSBlock(List<JSAst> members){
      this.members = members;
   }
   public void genCode(PrintStream out){
       this.members.stream().filter(t -> t != null)
	                        .forEach( t -> t.genCode(out));
   }
   
}