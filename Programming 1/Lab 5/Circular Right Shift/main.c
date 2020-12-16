#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int n , k  ;
    scanf("%i" , &n);
    scanf("%i" , &k);
    int myset1[n];
    int myset2[n];
    for (int i = 0 ; i < n ; i ++)
    {
        scanf("%i" , &myset1[i]);
        myset2[i] = myset1[i];
    }
    for ( int i = 0 ; i < n  ; i ++)
    {
        if (k >= (n - i))
        {
            if ((i + k - n) > (n - 1))
            {
                myset1[i - 2*n +k] = myset2[i];
            }
            else
            {
                myset1[i + k - n] = myset2[i];
            }
        }
        else
        {
            myset1[i + k] = myset2[i];

        }
    }
    for (int i = 0 ; i < n ; i ++)
    {
        printf("%i " , myset1[i]);
    }

}
