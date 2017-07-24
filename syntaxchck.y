%{
#include <stdio.h>
%}

%token  ID NUM
%%

statement: ID '=' expression
    | expression        { printf("correct syntax\n"); }
    ;

expression: expression '+' expression
    | expression '-' expression
    | expression '*' expression
    | expression '/' expression
    | ID | NUM
    ;

%%

main()
{
   printf("Enter the arithmetic expression: ");
   yyparse();
}
yyerror()
{
   printf("stderr");
   exit(0);
}
