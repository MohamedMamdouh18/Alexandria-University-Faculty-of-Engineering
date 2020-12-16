#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int i ;
    scanf("%i" , &i);
    int count = 0 ;
 
    for (int n = 1 ; n <= i ; n++)
    {
        if (i % n == 0)
        {
            count ++ ;
        }
    }

    if (count == 2)
    {
        printf("%i is prime" , i);
    }
    else
    {
        printf("%i is not prime" , i);
    }
}
