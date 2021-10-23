#include <stdio.h>
#include <stdlib.h>

int main()
{
   double R1 , R2 , R3 , Req;

   printf("R1 =");
   scanf("%lf" , &R1);

   printf("R2 =");
   scanf("%lf" , &R2);

   printf("R3 =");
   scanf("%lf" , &R3);

   printf("Req in series = %lf \n" , R1 + R2 + R3);
   printf("Req in parallel = %lf \n" , 1/((1 / R1) + (1 / R2) + (1 / R3)));
}
