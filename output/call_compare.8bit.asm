
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
	PUSH [.compare_y];
	PUSH [.compare_x];
	PUSH [.compare_ra];
	MOV [.compare_ra],C;
	MOV [.compare_y],A;
	MOV [.compare_x],B;if:
	PUSH [.compare_x];
	PUSH [.compare_y];
	POP B;
	POP A;
	CMP A,B;
	JBE out;
	PUSH 0;
	JMP end_compare;
	JMP return;
out:
	PUSH 1;
	JMP end_compare;
	JMP return;
return:
end_compare:
	POP A;
	MOV C,[.compare_ra];
	POP B;
	MOV [.compare_ra],B;
	POP B;
	MOV [.compare_x],A;
	POP B;
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
	