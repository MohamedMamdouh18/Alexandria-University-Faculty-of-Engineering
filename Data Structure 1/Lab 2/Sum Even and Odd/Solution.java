import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] sumEvenOdd(int[] array) {
        int[] sums = new int[2] ;
        for(int i = 0 ; i < array.length ; i ++)
        {
            if(array[i] % 2 == 0)
            {
                sums[0] += array[i] ;
            }
            else
            {
                sums[1] += array[i] ;
            }
        }
        return sums ;
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in) ;
       String s1 = input.nextLine().replaceAll("\\[|\\]", "") ;
       String[] s2 = s1.split(", ") ;
       int[] a1 = new int[s2.length] ;
       if(s2.length == 1 && s2[0].isEmpty())
       {
           System.out.println("[0, 0]");
           return ;
       }
       else
       {
           for(int i = 0 ; i < s2.length ; i ++)
           {
               a1[i] = Integer.parseInt(s2[i]) ;
           }
       }
       
       Solution y = new Solution() ;
       int[] a2 = y.sumEvenOdd(a1) ;
       System.out.print("[");
       for(int i = 0 ; i < a2.length ; i ++)
       {
           System.out.print(a2[i]);
            if(i != a2.length - 1)
              System.out.print(", ");
       }
       System.out.print("]");
    }
}
