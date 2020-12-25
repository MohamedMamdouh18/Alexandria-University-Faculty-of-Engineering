#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct fraction
{
   int numerator ;
   int denominator ;
}fraction ;

int swap(int *a , int *b) ;
int fraction_equivalence(fraction *num1 , fraction *num2) ;
fraction fraction_add(fraction num1 , fraction num2) ;
fraction fraction_subtract(fraction num1 , fraction num2) ;
fraction fraction_multiply(fraction num1 , fraction num2) ;
fraction fraction_divide(fraction num1 , fraction num2) ;
fraction fraction_simplify_GCD(fraction num1) ;

int main()
{
    fraction number1 , number2 , result;
    printf("First fraction:") ;
    scanf("%d/%d" , &number1.numerator , &number1.denominator) ;
    while (number1.denominator == 0)
    {
        printf("can't divide by zero\n");
        printf("First fraction:") ;
        scanf("%d/%d" , &number1.numerator , &number1.denominator) ;
    }

    char oper ;
    printf("Operator:") ;
    scanf(" %c" , &oper) ;
    while (oper != '+' && oper != '-' && oper != '/' && oper != '*')
    {
        printf("Invalid operation\n");
        printf("Operation:") ;
        scanf(" %c" , &oper) ;
    }

    printf("Second fraction:") ;
    scanf("%d/%d" , &number2.numerator , &number2.denominator) ;
    while (number2.denominator == 0)
    {
        printf("can't divide by zero\n");
        printf("Second fraction:") ;
        scanf("%d/%d" , &number2.numerator , &number2.denominator) ;
    }
    while (number2.numerator == 0 && oper == '/')
    {
        printf("can't divide by zero\n");
        printf("Second fraction:") ;
        scanf("%d/%d" , &number2.numerator , &number2.denominator) ;
    }


    switch(oper)
    {
        case '+' :
            result = fraction_add(number1 , number2) ;
            break ;
        case '-' :
            result = fraction_subtract(number1 , number2) ;
            break ;
        case '*' :
            result = fraction_multiply(number1 , number2) ;
            break ;
        case '/' :
            result = fraction_divide(number1 , number2) ;
            break ;
    }

    result = fraction_simplify_GCD(result) ;
    if(result.numerator == 0)
    {
        printf("The result : 0/1 \n");
    }
    else
    {
    printf("The result : %i/%i \n" , result.numerator , result.denominator) ;
    }
}

int swap(int *a , int *b)
{
    int temp = *a ;
    *a = *b ;
    *b = temp ;
}

int fraction_equivalence(fraction *num1 , fraction *num2)
{
    int first = num1->denominator ;
    int second = num2->denominator ;
    num1->numerator *= second ;
    num1->denominator *= second ;
    num2->numerator *= first ;
    num2->denominator *= first ;
}

fraction fraction_add(fraction num1 , fraction num2)
{
    fraction result ;
    fraction first_add = num1 ;
    fraction second_add = num2 ;
    fraction_equivalence(&first_add , &second_add) ;
    result.denominator = first_add.denominator ;
    result.numerator = first_add.numerator + second_add.numerator ;
    return result ;
}

fraction fraction_subtract(fraction num1 , fraction num2)
{
    fraction result ;
    fraction first_add = num1 ;
    fraction second_add = num2 ;
    fraction_equivalence(&first_add , &second_add) ;
    result.denominator = first_add.denominator ;
    result.numerator = first_add.numerator - second_add.numerator ;
    return result ;
}

fraction fraction_multiply(fraction num1 , fraction num2)
{
    fraction result ;
    result.numerator = num1.numerator * num2.numerator ;
    result.denominator = num1.denominator * num2.denominator ;
    return result ;
}

fraction fraction_divide(fraction num1 , fraction num2)
{
    fraction result ;
    swap(&num2.denominator , &num2.numerator) ;
    result.numerator = num1.numerator * num2.numerator ;
    result.denominator = num1.denominator * num2.denominator ;
    return result ;
}

fraction fraction_simplify_GCD(fraction num1)
{
    int a , b , max = 1 ;
    fraction result ;
    if(num1.numerator >= num1.denominator)
    {
        a = abs(num1.numerator) ;
        b = num1.denominator ;
    }
    else
    {
        b = abs(num1.numerator) ;
        a = num1.denominator ;
    }

    for(int i = 1 ; i <= b ; i ++)
    {
        if((a % i == 0) && (b % i == 0))
        {
            max = i ;
        }
    }
    result.numerator = num1.numerator / max ;
    result.denominator = num1.denominator / max ;
    return result ;
}
