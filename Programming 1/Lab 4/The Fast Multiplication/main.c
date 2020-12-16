#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int y , x , z;

    scanf("%i", &x) ;
    scanf("%i", &y) ;
    
    if((x < -1000) || (x > 1000) || (y < 0) || (y > 11) ){
        printf("-1000 < x  1000 // 0 < y < 11");
    }
    
    z = (x << y) ;
    printf("%i" , z);
}
