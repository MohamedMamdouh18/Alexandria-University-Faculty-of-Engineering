#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int n  ;
    scanf("%i" , &n);
    int set1[n];
     for (int i = 0 ; i < n ; i ++)
    {
        scanf("%i" , &set1[i]);
    }
    int m ;
    scanf("%i" , &m);
    int set2[m] ;
    for (int i = 0 ; i < m ; i ++)
    {
        scanf("%i" , &set2[i]);
    }
    for (int i = 0 ; i < n ; i ++)
    {
        for (int j = 0 ; j < i ; j ++)
        {
            if (set1[i] == set1[j])
            {
                for (int k = i ; k < n ; k ++)
                {
                    set1 [k] = set1[k+1];
                }
                i--;  
                n--;
            }
        }
    }
    for (int i = 0 ; i < m ; i ++)
    {
        for (int j = 0 ; j < i ; j ++)
        {
            if (set2[i] == set2[j])
            {
                for (int k = i ; k < m ; k ++)
                {
                    set2[k] = set2[k+1] ;
                }
                i--;  
                m--;
            }
        }
    }
    int l = m + n ;
    int uni[l] ;
    for (int i = 0 ; i < n ; i ++)
    {
        uni[i] = set1[i];
    }
    for (int i = n ; i < n + m ; i ++)
    {
        uni[i] = set2[i - n];
    }
    for (int i = 0 ; i < l ; i ++)
    {
        for (int j = 0 ; j < i ; j ++)
        {
            if (uni[i] == uni[j])
            {
                for (int k = i ; k < m + n ; k ++)
                {
                    uni[k] = uni[k+1] ;
                }
                i--; 
                l--;
            }
        }
    }
    int count = 0 ;
    int inter[100] ;
    for (int i = 0 ; i < n ; i ++)
    {
        for (int j = 0 ; j < m ; j ++)
        {
            if(set1[i] == set2[j])
            {
                inter[count] = set1[i];
                count ++ ;
            }
        }
    }
    printf("Array1: ");
    for (int i = 0 ; i < n ; i ++)
    {   if (i == n-1)
        {
        printf("%i\n" , set1[i]);
        }
        else
        {
        printf("%i, " , set1[i]);
        }    
    }
    printf("Array2: ");
    for (int i = 0 ; i < m ; i ++)
    {   if (i == m-1)
        {
        printf("%i\n" , set2[i]);
        }
        else
        {
        printf("%i, " , set2[i]);
        }    
    }
    printf("Union: ");
    for (int i = 0 ; i < l ; i ++)
    {   if (i == l - 1)
        {
        printf("%i\n" , uni[i]);
        }
        else
        {
        printf("%i, " , uni[i]);
        }    
    }
    printf("Intersection: ");
    for (int i = 0 ; i < count ; i ++)
    {   if (i == count - 1)
        {
        printf("%i" , inter[i]);
        }
        else
        {
        printf("%i, " , inter[i]);
        }    
    }
}
