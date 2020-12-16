#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int month ;
    scanf("%i" , &month) ;
        
    switch(month)
    {
        case 1:
            printf("January");
            return 0 ;

        case 2:
            printf("February");
            return 0 ;

        case 3:
            printf("March");
            return 0 ;

        case 4:
            printf("April");
            return 0 ;

        case 5:
            printf("May");
            return 0 ;

        case 6:
            printf("June");
            return 0 ;

        case 7:
            printf("July");
            return 0 ;
            
         case 8:
            printf("August");
            return 0 ;

        case 9:
            printf("September");
            return 0 ;

        case 10:
            printf("October");
            return 0 ;

        case 11:
            printf("November");
            return 0 ;

        case 12:
            printf("December");
            return 0 ;

        default:
            printf("Error");
    }
    
}
