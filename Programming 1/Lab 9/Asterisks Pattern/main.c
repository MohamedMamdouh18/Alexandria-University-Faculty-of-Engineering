#include <stdio.h>
#include <stdlib.h>

void draw_upper_loops(int n) ;
void draw_upper_loops(int n) ;
void print_asters(int n) ;

int main()
{
    int n ;
    scanf("%i" , &n) ;
    draw_upper_loops(n) ;
    draw_lower_loops(n - 1) ;
}

void draw_upper_loops(int n)
{
    if(n == 0)
    {
        return ;
    }

    draw_upper_loops(n - 1) ;
    print_asters(n) ;
    printf("\n");
}

void draw_lower_loops(int n)
{
    if(n == 0)
    {
        return ;
    }
    print_asters(n) ;
    printf("\n");
    draw_lower_loops(n - 1) ;

}

void print_asters(int n)
{
    if(n == 0)
    {
        return ;
    }
    printf("#");
    print_asters(n - 1) ;
}
