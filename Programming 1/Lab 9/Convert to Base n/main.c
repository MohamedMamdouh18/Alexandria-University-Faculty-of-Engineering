#include <stdio.h>
#include <stdlib.h>

void turn_base(int n , int b ) ;

int main()
{
    int n , b ;
    scanf("%i %i" , &n , &b );
    turn_base(n , b ) ;
}

void turn_base(int n , int b )
{
    if(n == 0)
    {
        return ;
    }
    turn_base(n/b , b ) ;

    if( n%b < 10)
    {
        printf("%i" , n%b) ;
    }
    else
    {
        printf("%c" , (n%b) + 55 ) ;
    }
}
