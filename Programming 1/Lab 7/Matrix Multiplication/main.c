#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int n , f , m ;
    scanf("%i %i %i" , &n , &f , &m);
    int mat1[n][f] , mat2[f][m] ;
    for(int i = 0 ; i < n ; i ++)
    {
        for(int j = 0 ; j < f ; j ++)
        {
            scanf("%i" , &mat1[i][j]);
        }
    }
    for(int i = 0 ; i < f ; i ++)
    {
        for(int j = 0 ; j < m ; j ++)
        {
            scanf("%i" , &mat2[i][j]);
        }
    }
    
    int maltp[n][m] ;
    memset(maltp, 0, sizeof(maltp[0][0]) * n * m); //built in function to zero out all the elements of the array
    
    for(int i = 0 ; i < n ; i ++)
    {
        for(int j = 0 ; j < m ; j ++)
        {
            for(int k = 0 ; k < f ; k ++)
            {
                maltp[i][j] += mat1[i][k] * mat2[k][j] ;
            }
        }
    }
    for(int i = 0 ; i < n ; i ++)
    {
        for(int j = 0 ; j < m ; j ++)
        {
            printf("%i " , maltp[i][j]) ;
        }
        printf("\n") ;
    }
}
