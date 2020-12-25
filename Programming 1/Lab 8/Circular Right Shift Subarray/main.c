#include <stdio.h>
#include <stdlib.h>

//reverse elements of subarray from a[left] to a[right]
void reverse(int a[], int left, int right) {
    for(int i = right ; i > left ; i --)
    {
        int j = a[i] ;
        a[i] = a[i - 1] ;
        a[i - 1] = j ;
    }
}

// shift the subarray a[left...right] to the right
//use reverse() as stated above
void shift(int a[], int left, int right, int k) {
    k = k % (right - left + 1) ;
        
    for(int i = 0 ; i < k ; i ++)
    {
        reverse(a , left , right) ;
    }
}

// reads a single query and process it by updateing a[]
void process_query(int a[]) {
   int left , right , k ;
   scanf("%i %i %i" , &left , &right , &k) ;
    if(left == right)
    {
        return ;
    }
   shift(a , left , right , k) ;
}

// scans array of size n
void scan_array(int a[], int n) {
   for(int i = 0 ; i < n ; i ++)
   {
       scanf("%i" , &a[i]) ;
   }
}

// print array of size n
void print_array(int a[], int n) {
   for(int i = 0 ; i < n ; i ++)
   {
       printf("%i " , a[i]) ;
   }
}

// don't change any thing in the main
int main() {

   int n, q;
   scanf("%d", &n);
   int a[n];
   scan_array(a, n);

   scanf("%d", &q);
   for(int i = 0; i < q; i++) {
      process_query(a);
   }

   print_array(a, n);

   return 0;
}
