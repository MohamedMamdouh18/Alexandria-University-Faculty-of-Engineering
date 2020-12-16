#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
 int r , c ;
 scanf("%i" , &r) ;
 scanf("%i" , &c) ;

 int mat1[r][c];
 int mat2[c][r];

 for(int i = 0 ; i < r ; i ++ )
 {
     for(int j = 0 ; j < c ; j ++ )
     {
         scanf("%i" , &mat1[i][j]);
     }
 }
 
  for(int i = 0 ; i < r ; i ++ )
 {
     for(int j = 0 ; j < c ; j ++ )
     {
         mat2[j][i] = mat1[i][j];
     }
 }

  for(int j = 0 ; j < c ; j ++  )
 {
     for(int i = 0 ; i < r ; i ++ )
     {
         if ( i == (r-1))
         {
             printf("%i\n" , mat2[j][i]);
         }
         else
         {
             printf("%i " , mat2[j][i]);
         }
     }
 }

}
