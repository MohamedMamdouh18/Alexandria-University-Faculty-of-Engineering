#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159

int main()
{
    float radius ;
    printf("The Radius:") ;
    scanf("%f" , &radius) ;

    printf("The diameter = %0.2f \n" , 2 * radius) ;
    printf("The circumference = %0.2f \n" , 2 * PI * radius) ;
    printf("The area = %0.2f \n" , PI * radius * radius ) ;
}
