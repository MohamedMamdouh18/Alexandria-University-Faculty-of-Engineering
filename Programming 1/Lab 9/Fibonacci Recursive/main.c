#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

long fib_func(int n) ;

int main() 
{
    int n ;
    long result;
    scanf("%i" , &n) ;
    result = fib_func(n) ;
    printf("Fibonacci of %i = %ld" , n , result) ;
}

long fib_func(int n)
{
    if(n == 1)
    {
        return 1 ;
    }
    else if(n == 0)
    {
        return 0 ;
    }
    else
    {
    return fib_func(n - 1) + fib_func(n - 2) ;
    }
}
