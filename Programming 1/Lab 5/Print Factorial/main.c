#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int n ;
    int fact = 1 ;
    scanf("%i" , &n);

    for (int i = 1 ; i <= n ; i ++)
    {
        fact = fact * i ;
    }

    printf("%i" , fact) ;
}
