#include <stdio.h>
#include <stdlib.h>

int main()
{
    int apples ;
    printf("apples that you have :") ;
    scanf("%i" , &apples) ;

    printf("%i dozens and %i apples" , apples / 12 , apples % 12) ;
}
