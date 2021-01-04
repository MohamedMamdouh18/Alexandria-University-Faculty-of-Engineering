#include <stdio.h>

void scan_all_arrays(int n ,int l , int a[]) ;
long long int sum_array(long long int num) ;
long long int least_array(long long int sum) ;

int main() 
{
    int n ;
    scanf("%i" , &n) ;
    int a[n] ;
    scan_all_arrays(n , n , a) ;
}

void scan_all_arrays(int n , int l , int a[])
{   long long int num , sum = 0;
    int least ;
    if(n == 0)
    {
        return ;
    }
    else
    {
        scanf("%lld" , &num) ;
        sum = sum_array(num) ;
        least = least_array(sum) ;
        a[n - 1] = least ;
        scan_all_arrays(n - 1 , l , a) ;
        printf("%i \n" , a[l - n]) ;
    }
}

long long int sum_array(long long int num) 
{   
    int n ;
    if(num == 0)
    {
        return 0;
    }
    scanf("%i" , &n) ;
    return n + sum_array(num - 1) ;
}

long long int least_array(long long int sum)
{   
    if(sum == 1)
    {
        return 1;
    }
    else
    {
        return (sum % 2) +  least_array(sum / 2) ;
    }
}
