.init:
	MOV D , 232
	.UNDEF:255
	JMP main

.fun1_data: 
	.fun1_a: DB 0;
	.fun1_b: DB 0;
	.fun1_String_1: DB "algo"
			DB 0;
	.fun1_c: DB 0;
	.fun1_z: DB 0;
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
