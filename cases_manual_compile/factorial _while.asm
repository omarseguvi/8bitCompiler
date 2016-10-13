.init:
     MOV D, 232
     JMP main

.fact_data:
	fact_n: DB 0;
	fact_f: DB 0;
.main_data:
.UNDEF: DB 255
.main_string_01: DB "fact(5)="
	 DB 0

fact_code:
	POP  C ;
	POP  A ;
	MOV  [fact_n], A;
	PUSH C ;
	
	MOV [fact_f], 1;
while:	
	MOV A, [fact_n];
	CMP A, 0;
	JBE return;
	
	MOV A, [fact_f];
	MUL [fact_n];	
	MOV [fact_f], A;
	
	MOV A, [fact_n];
	SUB A, 1;
	MOV [fact_n], A;
	JMP while;

return:
	POP C;
	PUSH [fact_f];
	PUSH C;
	RET;
	
print_number:
     POP C
     POP A
     PUSH C 
.number_to_Stack:
         MOV B,A;
	 DIV 10;
  	 MUL 10;
	 SUB B, A;
	 PUSH B;
	 CMP A, 0;
	 JE .number_to_display;
	 DIV 10;
	 JMP .number_to_Stack;
.number_to_display:
     	POP A;
	CMP A,C;
	JE .exit;
     	ADD A, 0x30;
	MOV [D], A;
	INC D;
	JMP .number_to_display;
.exit:	
     	PUSH .UNDEF
     	PUSH C
     	RET

print_string:
     POP C
     POP B
     PUSH C 
.print_string_loop_01:
     MOV C, [B]
	 CMP C, 0
	 JE .print_string_exit
	 MOV [D], C
	 INC D
	 INC B
	 JMP .print_string_loop_01
.print_string_exit:
     POP C 
     PUSH .UNDEF
     PUSH C
     RET

main:
	PUSH .main_string_01
	CALL print_string
	PUSH 5
	CALL fact_code 
	CALL print_number;
   	HLT             ; Stop execution