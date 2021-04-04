import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] moveValue(int[] array, int value) {
        int[] m = new int[array.length] ;
        int start = 0 , end = array.length - 1;
        for(int i = 0 ; i < array.length ; i ++)
        {
            if(array[i] == value)
            {
                m[end] = array[i] ;
                end -- ;
            }
            else
            {
                m[start] = array[i] ;
                start ++ ;
            }
        }
        return m ;
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in) ;
       String s1 = input.nextLine().replaceAll("\\[|\\]", "") ;
       int m = input.nextInt() ;
       String[] s2 = s1.split(", ") ;
       int[] a1 = new int[s2.length] ;
       if(s2.length == 1 && s2[0].isEmpty())
       {
           System.out.println("[]");
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
       int[] a2 = y.moveValue(a1 , m) ;
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
