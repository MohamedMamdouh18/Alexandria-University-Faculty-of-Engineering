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
    int list[10] ;
    int j = 0 ;
    while(a > 0)
    {
        list[j] = a % 10 ;
        a = a / 10 ;
        j ++ ;
    }
    if (b > j)
    {
        printf("0") ;
    }
    else
    {
    printf("%i" , list[b - 1]) ;
    }
}
