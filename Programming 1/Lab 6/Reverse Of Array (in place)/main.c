#include <stdio.h>
#include <stdlib.h>
int main() {
    int n ;
    scanf("%i" , &n);
    int arr[n];
    for (int i = n - 1 ; i >= 0 ; i --) {
      scanf ("%i" , &arr[i]);
    }
    for (int i = 0 ; i < n ; i ++){
        printf ("%i " , arr[i]);}
}
