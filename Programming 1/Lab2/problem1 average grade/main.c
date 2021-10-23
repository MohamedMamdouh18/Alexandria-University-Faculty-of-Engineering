#include <stdio.h>
#include <stdlib.h>

int main()
{
    int first , second , third , fourth , fifth ;

    printf("first grade:") ;
    scanf("%i" , &first) ;

    printf("second grade:") ;
    scanf("%i" , &second) ;

    printf("third grade:") ;
    scanf("%i" , &third) ;

    printf("fourth grade:") ;
    scanf("%i" , &fourth) ;

    printf("fifth grade:") ;
    scanf("%i" , &fifth) ;

    int sum = first + second + third + fourth + fifth ;
    float average = sum / 5.0 ;

    printf("%0.2f" , average) ;

}
