#include <stdio.h>
#include <stdlib.h>

int main() {


    int x, y;
    scanf("%d %d", &x, &y);
    char z;

    if ((x < 0) ||(y < 0) ||(x > 15) ||(y > 15) ){
        printf("Error");
        return 0 ;
    }

    x = x << 4 ;
    z = x | y ;
    
    printf("%d\n", z);

}
