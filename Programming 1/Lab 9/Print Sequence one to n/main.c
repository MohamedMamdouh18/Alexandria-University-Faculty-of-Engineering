#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void print_seq(int n) ;

int main() 
{
    int n ;
    scanf("%i" , &n) ;
    print_seq(n) ;
}

void print_seq(int n)
{
    if (n == 1)
    {
        printf("%i " , 1) ;  
    }
    else
    {
        print_seq(n - 1) ,
        printf("%i " ,  n ) ;
    }
}
