.init:
     MOV D, 232
     JMP main
; Data Area
main_data:
.UNDEF: DB 255
.main_string_01: DB "10>5="
	 DB 0
.main_string_02: DB "5>10="
	 DB 0
compare_data:
.compare_int_01: DB 10d
.compare_int_02: DB 5d

compare_return: DB " "
		 DB 0
.compare_string_true: DB "true"
	 DB 0
.compare_string_false: DB "false"
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

compare:
  POP C
  POP A
  PUSH C
  POP C
  POP B
  PUSH C
  SUB A, B
  JNC .greater
  MOV [compare_return], .compare_string_false
  RET


.greater:
 	MOV [compare_return], .compare_string_true
	RET
 
main:
     PUSH .main_string_01
     CALL print_string
     POP A
     PUSH .compare_int_01
     PUSH .compare_int_02
     CALL compare
     PUSH [compare_return]
     CALL print_string
     POP A
     INC D
     PUSH .main_string_02
     CALL print_string
     POP A
     PUSH .compare_int_02
     PUSH .compare_int_01
     CALL compare
     PUSH [compare_return]
     CALL print_string
     POP A
     HLT