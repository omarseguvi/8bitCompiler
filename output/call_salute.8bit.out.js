
.main_data:
	.main_String_1: DB "Hello 666!" 
	DB 0;
.salute_data:
	.salute_s: DB 0;
	.salute_ret: DB 0;
.init:
	MOV D,232;
	.UNDEF: DB 255;
	main;
