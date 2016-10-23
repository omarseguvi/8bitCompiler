
.init:
	MOV D,232;
	JMP main;
	.UNDEF: DB 255;
.compare_data:
	.compare_x: DB 0;
	.compare_y: DB 0;
	.compare_ra: DB 0;
.main_data:
	.main_String_2: DB " 5>10=" 
	DB 0;
	.main_String_1: DB "10>5=" 
	DB 0;
	.true: DB "true"
	DB 0;
	.false: DB "false"
	DB 0;
compare:
	POP C;
	POP A;
	POP B;
	PUSH [.compare_x];
	PUSH [.compare_y];
	PUSH [.compare_ra];
	MOV [.compare_ra],C;
	MOV [.compare_x],A;
	MOV [.compare_y],B;if:
	PUSH [.compare_x];
	PUSH [.compare_y];
	POP B;
	POP A;
	CMP A,B;
	JA out;
	PUSH 0;
	JMP return;out:
	PUSH 1;
	JMP return;return:
	POP A;
	MOV C,[.compare_ra];
	POP B;
	MOV [.compare_ra],B;
	MOV [.compare_x],A;
	MOV [.compare_y],B;
	PUSH A;
	PUSH C;
	RET;
	
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
.print_bool:
	CMP A, 0;
	JZ .print_true;
	CMP A, 1;
	JZ .print_false;
.print_true:
	PUSH .true
	CALL .print_string
	POP A
	JMP .print_bool_exit
.print_false:
	PUSH .false
	CALL .print_string
	POP A
	JMP .print_bool_exit
.print_bool_exit:
	POP C
	PUSH .UNDEF
	PUSH C
	RET


main:
	PUSH .main_String_1;
	CALL print_string;
	PUSH 10;
	PUSH 5;
	CALL compare;
	CALL print_boolean;
	PUSH .main_String_2;
	CALL print_string;
	PUSH 5;
	PUSH 10;
	CALL compare;
	CALL print_boolean;
	HLT;
	