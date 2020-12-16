#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int n , m ;
    scanf("%i %i" , &n , &m);
    int list[n] ;
    memset(list , 0 , sizeof(list[0]) * n) ;
    int mat[n][m];
    for(int i = 0 ; i < n ; i ++)
    {
        for(int j = 0 ; j < m ; j++)
        {
            scanf("%i" , &mat[i][j]) ;
            list[i] += mat[i][j] ;
        }
    }
    int max_num = -1000 , max_ind = 0;
    for(int i = 0 ; i < n ; i ++)
    {
        if(list[i] > max_num)
        {
            max_num = list[i] ;
            max_ind = i ;
        }
    }
    for(int i = 0 ; i < m ; i++)
    {
        int a = mat[max_ind][i] ;
        mat[max_ind][i] = mat[0][i] ;
        mat[0][i] = a ;
    }
    for(int i = 0 ; i < n ; i ++)
    {
        for(int j = 0 ; j < m ; j++)
        {
            printf("%i " , mat[i][j]);
        }
        printf("\n");
    }
}
