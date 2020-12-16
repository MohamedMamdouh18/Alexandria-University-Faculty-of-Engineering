#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main() {

    double a, b, c, d, e, f, g, x, y, z;
    double ans1, ans2, ans3, ans4;
      scanf("%lf %lf %lf %lf %lf %lf %lf", &a, &b, &c, &d, &e, &f, &g);
    scanf("%lf %lf %lf", &x, &y, &z);

    ans1 = (3 * x + 2 * pow(10 , 5) ) / (4 * x + 5.2 * pow(10 , 4)) ;
    ans2 = 5 * pow( (x + y + 3) / (27 + z), 2) ;
    ans3 = (a + (b/c)) /(d + (e / (f + g))) ;
    ans4 = pow ( sin(x+y) ,2 ) ;


      printf("%.5lf %.5lf %.5lf %.5lf", ans1, ans2, ans3, ans4);
    return 0;
}

