#include<stdlib.h>
#include<stdio.h>
#include<math.h>
#define M_PI 3.14159265358979323846

double fact(int num);

int main() {

    double x;
    int n;
    scanf("%lf %d", &x, &n);


    x = (x * M_PI) / 180;
    double ans = 0;

    for (int i = 1 ; i <= n ; i ++)
    {
        ans += pow(-1 , i + 1) * (pow(x , 2 * i - 1) / fact(2 * i - 1));
    }

    printf("calculated %.10lf expected %.10lf\n", ans, sin(x));


    return 0;
}
double fact(int num)
{
    double fact = 1 ;
    for (int i = 1 ; i <= num ; i ++)
    {
        fact = fact * i ;
    }
    return fact;
}
