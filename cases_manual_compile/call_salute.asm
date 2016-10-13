.init:
     MOV D, 232
     JMP main
; Data Area
main_data:
.UNDEF: DB 255
salute_data:
.salute_string_01: DB "Hello 666!"
	 	   DB 0
; Code Area Prólogo

print_string:
     POP A
     POP B
     PUSH A
.print_string_loop_01:
     MOV A, [B]
	 CMP A, 0
	 JE .print_string_exit
	 MOV [D], A
	 INC D
	 INC B
	 JMP .print_string_loop_01
.print_string_exit:
     POP A
     PUSH .UNDEF
     PUSH A
     RET

salute:
	POP C
	CALL print_string
	PUSH .UNDEF
	PUSH C
	RET
main:
     PUSH .salute_string_01
     CALL salute
     HLT