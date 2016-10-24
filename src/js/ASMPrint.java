package eightBit.js;
import java.io.*;

public class ASMPrint implements ASMAst{
  private int type; //1-> string, 2-> number, 3 -> boolean

  public ASMPrint(int tipo){ //1-> string, 2-> number, 3 -> boolean
    this.type = tipo;
  }


  public void genCode(PrintStream out){
    if(type == 1){
      out.print("\n"+
      "print_string:\n"+
           "\tPOP C\n"+
           "\tPOP B\n"+
           "\tPUSH C \n"+
      ".print_string_loop_01:\n"+
          "\tMOV C, [B]\n"+
      	  "\tCMP C, 0\n"+
          "\tJE .print_string_exit\n"+
      	  "\tMOV [D], C\n"+
      	  "\tINC D\n"+
      	  "\tINC B\n"+
      	  "\tJMP .print_string_loop_01\n"+
      ".print_string_exit:\n"+
          "\tPOP C\n"+
          "\tPUSH .UNDEF\n"+
          "\tPUSH C\n"+
          "\tRET\n");
    }
    else if(type == 2){
      out.print("\n"+
    "print_number:\n"+
          "\tPOP C\n"+
          "\tPOP A\n"+
          "\tPUSH C\n"+
    ".number_to_Stack:\t"+
          "\tMOV B,A;\n"+
      	  "\tDIV 10;\n"+
        	"\tMUL 10;\n"+
      	  "\tSUB B, A;\n"+
      	  "\tPUSH B;\n"+
      	  "\tCMP A, 0;\n"+
      	  "\tJE .number_to_display;\n"+
      	  "\tDIV 10;\n"+
      	  "\tJMP .number_to_Stack;\n"+
    ".number_to_display:\n"+
          "\tPOP A;\n"+
      	  "\tCMP A,C;\n"+
      	  "\tJE .exit;\n"+
          "\tADD A, 0x30;\n"+
      	  "\tMOV [D], A;\n"+
      	  "\tINC D;\n"+
      	  "\tJMP .number_to_display;\n"+
          "\t.exit:\n"+
          "\tPUSH .UNDEF\n"+
           	"\tPUSH C\n"+
           	"\tRET\n");
    }
    else{
      out.println("\n"+
      "print_boolean:\n"+
      "\tPOP C;\n"+
      "\tPOP A;\n"+
      "\tPUSH C;\n"+
      "\tCMP A, 0;\n"+
      "\tJNE .print_false;\n"+
      "\tPUSH .true\n"+
      "\tJMP .pb_exit:\n"+
      ".print_false:\n"+
      "\tPUSH .false\n"+
      "\tJMP .pb_exit:\n"+
      "\t.pb_exit:\n"+
      "\tCALL print_string;\n"+
      "\tPOP C;\n"+
      "\tPOP C;\n"+
      "\tPUSH .UNDEF\n"+
      "\tPUSH C\n"+
      "\tRET\n");
    }
  }

}
