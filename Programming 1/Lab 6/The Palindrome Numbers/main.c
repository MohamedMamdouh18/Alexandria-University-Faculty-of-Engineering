#include <stdio.h>
#include <stdlib.h>

int main()
{
    long n ;
    int num[100] ;
    int count = 0 ;
    scanf("%ld" , &n);
    long x = n ;

    while (n != 0)
    {
        num[count] = n % 10; ;
        count ++ ;
        n = n / 10 ;
    }

    for ( int i = 0 ; i < count / 2 ; i ++)
    {
        if(num[i] != num[count - 1 - i])
        {
            printf("%ld is not a palindrome number" , x);
            return 0 ;
        }
    }
    printf("%ld is a palindrome number" , x);
}
