.init:
     MOV D, 232
     JMP main
; Data Area
.main_data:
.UNDEF: DB 255
.main_string_01: DB "5="
  DB 0
.add_data:
num_01: DB 5
fac_return: DB 0
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

fac:
    POP C
    POP A
    MOV B, 1
    PUSH C
    
.while:
    CMP A, 0
    JE .fin
    PUSH A
    MUL B
    MOV B, A
    POP A
    SUB A, 1
    JMP .while

.fin:
    MOV [fac_return], B
    PUSH .UNDEF
    PUSH C
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
    PUSH [num_01]
    CALL fac
    PUSH [fac_return]
    CALL print_number
    HLT
