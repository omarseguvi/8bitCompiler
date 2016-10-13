.init:
     MOV D, 232
     JMP main
; Data Area
.main_data:
.UNDEF: DB 255
.main_string_01: DB "10+56="
	 DB 0
.add_data:
add_num_01: DB 10
add_num_02: DB 56
add_return: DB 0
; Code Area Prólogo

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

add:
  POP C
  POP A
  POP B
  PUSH C
  ADD A, B
  MOV [add_return], A
  RET
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

main:
     	PUSH .main_string_01
    	CALL print_string
	POP A
	PUSH [add_num_01]
	PUSH [add_num_02]
	CALL add
	PUSH [add_return]
	CALL print_number
	 HLT
