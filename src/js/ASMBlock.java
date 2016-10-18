package eightBit.js;
import java.util.*;
import java.io.*;
public class ASMBlock implements ASMAst{
   protected List<ASMAst> members;
   protected List<ASMAst> vars;
   protected ASMId name;

   public List<ASMAst> getMembers(){
	   return this.members;
   }

   public List<ASMAst> getVars(){
     return this.vars;
   }
   public ASMBlock(List<ASMAst> members){
     this.members = members;
     this.vars = null;
   }
   public ASMBlock(List<ASMAst> members, List<ASMAst> vars){
      this.members = members;
      this.vars = vars;
   }

   public void setName(ASMId name){
     this.name = name;
   }

   public void genCode(PrintStream out){
       if(this.members != null)
       this.members.stream().filter(t -> t != null)
	                          .forEach( t -> out.format("\t%s_%s: DB 0;\n",name.getValue(),((ASMId)t).getValue()) );
       if(this.vars != null)
       this.vars.stream().filter(t -> t != null)
                         .forEach( t -> out.format("\t%s_%s: DB %s DB 0;\n",name.getValue(),((ASMVar)t).getName(),((ASMVar)t).getValue()));
   }

}