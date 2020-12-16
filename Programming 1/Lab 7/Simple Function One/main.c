#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
void simple_func_one(int a) ;

int main()
{
    int x ;
    scanf("%i" , &x) ;
    simple_func_one(x) ;
    return 0;
}

void simple_func_one(int a)
{
    long long int s ;
    s = 3 * pow(a , 5) +2 * pow(a , 4) -5 * pow(a , 3) - pow(a , 2) + 7 * a -6 ;
    printf("%lld" , s) ;
}
