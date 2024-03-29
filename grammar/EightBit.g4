/*
 loriacarlos@gmail.com EIF400 II-2016
 EightBit starting grammar

 Used By: 
 Gabriel Andrés Moreno Leiter A00125558
 Omar Segura Villegas 116110577
 Andrey Campos Sánchez 504070843
 Fabian Hernandez Chavarria 402270173
 Carlos Artavia Pineda 116390735

*/
grammar EightBit;

// START
eightProgram       : eightFunction+
;
////////////////////////////////////////////////////////////////////////
// FUN
eightFunction      : 'fun' id formals  funBody
;

formals            : '(' idList? ')'
;
idList             : id (',' id)*
;
id                 : ID
;
funBody            :   letStatement
                     | closedStatement
                     | emptyStatement
;
////////////////////////////////////////////////////////////////////////
// STATEMENT
emptyStatement       : ';'
;
letStatement       : 'let' '{'  assignStmtList? '}' closedStatement
;
assignStmtList     : assignStatement (';' assignStatement)*
;
closedStatement     : assignStatement
                    | whileStatement
					| ifStatement
					| callStatement
					| returnStatement
					| blockStatement

;
assignStatement         : id '=' expr
;
whileStatement          : 'while' '('  expr ')' closedStatement
;
ifStatement             : 'if' '('  expr ')' closedStatement ('else' closedStatement)?
;
callStatement           : ID arguments
;
returnStatement         : 'return' expr
;
blockStatement          : '{' closedList?  '}'
;
closedList              : closedStatement ';'? ( closedStatement ';'?)*
;
//////////////////////////////////////////////////////////////////////////////////
// EXPRESSION
expr            : relMonom ('||' relMonom)*
;
relMonom        : relOperation ('&&' relOperation)*
;

relOperation    : arithOperation ((relOperator = ('>' | '<' | '==' | '<=' | '>=' | '!='))   arithOperation)*
                    | '!'  relOperation
;


arithOperation  : arithMonom  operArithOperation*
;

operArithOperation: (oper = ('+' | '-'))  arithMonom
;
arithMonom      : arithSingle operTDArithSingle*
;

arithSingle     :  '-' arithOperation #ArithMinusSingle
                   | '(' expr ')'     #ArithParsSingle
				   | id arguments?    #ArithIdSingle
				   | constant         #ArithConstantSingle


;
operTDArithSingle : (oper = ('*' | '/')) arithSingle
;
constant        :    NUMBER  #ExprNum
                   | STRING  #ExprString
				   | 'true'  #ExprTrue
				   | 'false' #ExprFalse
				   | 'null'  #ExprNull
;

arguments : '(' args? ')'
;

args   :  expr (',' expr)*
;
///////////////////////////////////////////////////////////////////////
// LEXER

NUMBER : ('-')? INTEGER ('.' INTEGER)?
;
fragment INTEGER : [0-9]+ ;

STRING : ('"' (~'"')* '"' )
;

NOT : '!'
;
EQ : '=='
;
NEQ : '!='
;
LEQ : '<='
;
OR : '||'
;
TRUE : 'true'
;
FALSE : 'false'
;
MUL :   '*'
;
DIV :   '/'
;
ADD :   '+'
;
SUB :   '-'
;
ID : [a-zA-Z][a-zA-Z_0-9]*
;
////////////////////////////////////////////////
// Ignored tokens
SLC :   '/*'.*? '*/' -> skip
;
MLC : '//'.*?'\r'?'\n' -> skip
;
WS  :   [ \t\r\n]+ -> skip
;
