#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int A , B , result1 ;
    char opr ;


    scanf("%i" , &A) ;
    scanf(" %c" , &opr) ;
    scanf("%i" , &B) ;
    
     if((A <= -1000) || (A >= 1000) || (B <= -1000) || (B >= 1000)){
        printf("-1000 <= A B <= 1000");
        return 0 ;
    }

    if( (opr != '+') && (opr != '-') && (opr != '/') && (opr != '%') && (opr != '*')){
        printf("ERROR: Unsupported Operator! \n") ;
    }

    if(opr == '+'){
        result1 = A + B ;
         printf("%i + %i = %i" , A , B , result1);
    }else if(opr == '-'){
        result1 = A - B ;
         printf("%i - %i = %i" , A , B , result1);
    }else if(opr == '*'){
        result1 = A * B ;
         printf("%i * %i = %i" , A , B , result1) ;
    }else if(opr == '%'){
        if(B == 0){
            printf("ERROR: Division by zero is not allowed! \n");
        }else{
            result1 = A % B ;
             printf("%i %% %i = %i" , A , B , result1) ;
        }
    } else if(opr == '/'){
        if(B == 0){
            printf("ERROR: Division by zero is not allowed! \n");
        }else{
            result1 = A / B ;
            printf("%i / %i = %i" , A , B , result1) ;
        }
    }

}
