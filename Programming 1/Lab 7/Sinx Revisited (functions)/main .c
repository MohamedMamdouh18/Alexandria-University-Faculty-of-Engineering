#include<stdlib.h>
#include<stdio.h>
#include<math.h>
#define M_PI 3.14159265358979323846

double rad(double a) ;
long long int fact(int b) ;
long double power_func(double m , int n) ;
double our_sine(double s , int n) ;

int main() {


    double ans = 0;
      double x ;
    int n ;
    scanf("%lf %i" , &x , &n) ;
    x = rad(x) ;
    ans = our_sine(x , n) ;

       printf("calculated %.10lf expected %.10lf\n", ans, sin(x));


       return 0;
}

double rad(double a)
{
    double x ;
    x = a * M_PI / 180 ;
    return x ;
}

long long int fact(int b)
{
    long long int fact = 1 ;
    for(int i = b ; i > 0 ; i --)
    {
        fact = fact * i ;
    }
    return fact ;
}

long double power_func(double m , int n)
{
    long double sum = 1 ;
    for(int i = 0 ; i < n ; i ++)
    {
        sum = sum * m ;
    }
    return sum ;
}

double our_sine(double s , int n)
{
    double value = 0 ;
    for(int i = 1 ; i <= n ; i ++)
    {
        value += power_func(-1 , i - 1) * (power_func(s , 2 * i - 1) / fact(2 * i - 1)) ;
    }
    return value ;
}
