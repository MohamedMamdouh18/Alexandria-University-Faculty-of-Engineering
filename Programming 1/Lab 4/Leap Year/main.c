#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int y ;
    
    scanf("%i" , &y) ;
    
    if( ((y % 4) == 0) ){
        if (((y % 100) == 0) && ((y % 400) == 0)){
            printf("Leap\n");
            return 0 ;
        }else if (((y % 100) == 0) && ((y % 400) != 0)){
            printf("Not Leap\n");
            return 0 ;
        }
        printf("Leap\n");
    }else{
        printf("Not Leap\n");
    }
}
