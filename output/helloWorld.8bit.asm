
.init:
	MOV D,232;
	JMP main;
	.UNDEF: DB 255;
.main_data:
	.main_String_1: DB "Hello World!" 
	DB 0;
	.true: DB "true" 
	DB 0;
	.false: DB "false" 
	DB 0;
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

print_number:
	POP C
	POP A
	PUSH C
.number_to_Stack:		MOV B,A;
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

print_boolean:
	POP C;
	POP A;
	PUSH C;
	CMP A, 0;
	JNE .print_false;
	PUSH .true
	JMP .pb_exit:
.print_false:
	PUSH .false
	JMP .pb_exit:
	.pb_exit:
	CALL print_string;
	POP C;
	POP C;
	PUSH .UNDEF
	PUSH C
	RET


main:
	PUSH .main_String_1;
	CALL print_string;
	HLT;
	