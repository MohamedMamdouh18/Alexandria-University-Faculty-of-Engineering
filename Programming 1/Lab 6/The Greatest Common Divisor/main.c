#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int a , b ;
    scanf("%i %i" , &a , &b);
    if((a > 1000) || (a < 0) || (b > 1000) || (b < 0))
    {
        return 0 ;
    }
    if(a == 0)
    {
        printf("%i" , b );
        return 0 ;
    }
    if(b == 0)
    {
        printf("%i" , a );
        return 0 ;
    }
    if ( a < b)
    {
        int temp = a ;
        a = b ;
        b = temp ;
    }
    int GCD ;
    for(int i = 1 ; i < b ; i ++)
    {
        if((a % i) == 0 && (b % i) == 0)
        {
            GCD = i ;
        }
    }
    printf("%i" , GCD);
}
