
.init:
	MOV D,232;
	JMP main;
	.UNDEF: DB 255;
.add_data:
	.add_x: DB 0;
	.add_y: DB 0;
	.add_ra: DB 0;
.main_data:
	.main_String_1: DB "10+56=" 
	DB 0;
	.true: DB "true" 
	DB 0;
	.false: DB "false" 
	DB 0;
add:
	POP C;
	POP A;
	POP B;
	PUSH [.add_y];
	PUSH [.add_x];
	PUSH [.add_ra];
	MOV [.add_ra],C;
	MOV [.add_y],A;
	MOV [.add_x],B;
	PUSH [.add_x];
	PUSH [.add_y];
	POP B;
	POP A;
	ADD A,B;
	PUSH A;
	JMP end_add;
end_add:
	POP A;
	MOV C,[.add_ra];
	POP B;
	MOV [.add_ra],B;
	MOV [.add_x],A;
	MOV [.add_y],B;
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
	PUSH 10;
	PUSH 56;
	CALL add;
	CALL print_number;
	HLT;
	