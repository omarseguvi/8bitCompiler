package eightBit.js;
import java.util.*;
import java.io.*;

public class ASMCBlock implements ASMAst{
   protected List<ASMAst> members;
   protected ASMId name;

   public List<ASMAst> getMembers(){
	   return this.members;
   }

   public ASMCBlock(List<ASMAst> members){
     this.members = members;
   }

   public void setName(ASMId name){
     this.name = name;
   }

   public void genCode(PrintStream out){
       if(this.members != null)
       this.members.stream().filter(t -> t != null);
	                          //.forEach( t -> out.format("\t%s_%s: DB 0;\n",name.getValue(),((ASMId)t).getValue()) );
   }

}
