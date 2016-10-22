
.init:
	MOV D,232;
	.UNDEF: DB 255;
	JMP main;
.main_data:
	.main_String_1: DB "Hello 666!" 
	DB 0;
.salute_data:
	.salute_s: DB 0;
	.salute_ret: DB 0;
salute:
	POP C;
	POP A;
	PUSH [.salute_s];
	PUSH [salute_ra];
	MOV [salute_ra],C;
	MOV [.salute_s],A;
	
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
	