#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int n , m ;
    scanf("%i" , &n);
    int set1[n];
    for (int i = 0 ; i < n ; i ++)
    {
        scanf("%i" , &set1[i]);
    }

    scanf("%i" , &m);
    int set2[m];
    for (int i = 0 ; i < m ; i ++)
    {
        scanf("%i" , &set2[i]);
    }
    int uni[m + n];
    int i = 0 , j = 0 , k = 0 ;
    while(k != m + n)
    {
        if(set1[i] <= set2[j] && i != n)
        {
            uni[k] = set1[i];
            k ++ ;
            i ++ ;
        }
        else if (i == n)
        {
           uni[k] = set2[j];
            k ++ ;
            j ++ ;
        }
        else if(set1[i] >= set2[j] && j != m)
        {
            uni[k] = set2[j];
            k ++ ;
            j ++ ;
        }
        else if (j == m)
        {
            uni[k] = set1[i];
            k ++ ;
            i ++ ;
        }
    }
    for (int i = 0 ; i < m + n ; i ++)
    {
        printf("%i " , uni[i]);
    }
}
