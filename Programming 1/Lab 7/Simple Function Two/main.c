#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
void simple_func_2(int a , int b) ;

int main() {
    int n , k ;
    scanf("%i %i" , &n , &k) ;
    simple_func_2(n , k);
    return 0;
}

void simple_func_2(int a , int b)
{
    int num ;
    int j = b ;
    while(j > 0)
    {
        num = a % 10 ;
        a = a / 10 ;
        j -- ;
    }
    printf("%i" , num) ;
}
