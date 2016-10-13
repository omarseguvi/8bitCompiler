.init:
     MOV D, 232
     JMP main
; Data Area
main_data:
.UNDEF: DB 255
salute_data:
.salute_return_01: DB "Hello 666!"
	 	   DB 0
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

salute:
	POP C
	PUSH .salute_return_01
	PUSH C
	RET
main:
     CALL salute
     CALL print_string
     POP A
     HLT