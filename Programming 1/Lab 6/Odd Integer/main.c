#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    int n , m;
    int a = 0 ;
    scanf("%d" , &n);
    for(int i = 0 ; i < n ; i ++)
    {   
        scanf("%d" , &m);
        a = a^m ;
    }
    printf("%d" , a) ;
        
}
