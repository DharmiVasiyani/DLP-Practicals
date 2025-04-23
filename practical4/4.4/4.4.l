%{
    #include<stdio.h>
    int digit = 0,lower = 0,upper = 0,special = 0,length = 0,count = 0;
%}

%%
[0-9] {digit++; length++;}
[a-z] {lower++; length++;}
[A-Z] {upper++; length++;}
[*,;#$@] {special++; length++;}
[\n] {
     
     if(count >1) printf("Invalid Password\n");
     
      else if(length>9 && length<15 && digit>0 && lower>0 && upper>0 && special>0 && count<1) printf("valid Password\n");
      else printf("Invalid Password\n");
      
      digit = 0;
      lower = 0;
      upper = 0;
      special = 0;
      length = 0;
      count =0;
     }
. {count++;}
%%

int main() {
    printf("Enter password: ");  
    yylex();
    return 0;
}

int yywrap(){
}
