#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    char string[256] ;
    char proto[256] ;
    gets(string ) ;
    gets(proto) ;
    int occur = 0 ;
    for(int i = 0 ; i < strlen(string) ; i++)
    {
        int n = 0 ;
        int times = 0 ;
        while (n < strlen(proto))
        {
            if(proto[n] == string[i + n])
            {
                times ++ ;
            }
            n ++ ;
        }
        if(times == strlen(proto))
        {
            printf("Occurrence at index %i\n" , i) ;
            occur ++ ;
        }
    }
    printf("Total number of occurrences = %i" , occur) ;
}
