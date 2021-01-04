#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

long long int calc_sum(long long int n) ;

int main()
{
    long long int n , res ;
    scanf("%lld" , &n) ;
    
    
    res = calc_sum(n) ; 
        
    
    printf("Sum of digits of %lld = %lld" , n , res) ;
}

long long int calc_sum(long long int n)
{
    if(n < 10 && n > -10)
    {
        return n ;
    }
    else
    {
        return (n % 10) + calc_sum(n / 10) ; 
    }
}
