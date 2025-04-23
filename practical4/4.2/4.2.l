%{
#include <stdio.h>
%}

%%
"charusat"    { printf("university"); }
"\n"        { printf("%s", yytext); }
%%

int main() {
    printf("Enter input text :\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}
