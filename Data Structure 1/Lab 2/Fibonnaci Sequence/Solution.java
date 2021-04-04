import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int fibonacci(int n) {
        int f1 = 0 , f2 = 1 , f3 = 1;
        if(n == 1)
        {
            return f1 ;
        }
        else if(n == 2 || n == 3)
        {
            return f2 ;
        }
        else
        {
            for(int i = 0 ; i < n - 3 ; i ++)
            {
                int temp = f2 ;
                f2 = f3 ;
                f3 += temp  ;
                f1 = temp ;
            }
            return f3 ;
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt() ;
        Solution y = new Solution() ;
        int fib = y.fibonacci(x);
        System.out.println(fib);
     }
}
