import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.Math.*;
import java.util.regex.*;

public class Solution {
	public int[][] transpose(int[][] array) {
        int[][] a = new int[array.length][array.length] ;
           for(int i = 0 ; i < array.length ; i ++)
           {
               for(int j = 0 ; j < array.length ; j ++)
               {
                   a[i][j] = array[j][i] ;
               }
           }
          return a ;
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in) ;
       String s1 = input.nextLine().replaceAll("\\[|\\]", "") ;
       String[] s2 = s1.split(", ") ;
       int x = (int)sqrt((double)s2.length) ;
       int[][] a1 = new int[x][x] ;
       if(s2.length == 1 && s2[0].isEmpty())
       {
           System.out.println("[[]]");
           return ;
       }
       else
       {
           int l = 0 ;
           for(int i = 0 ; i < x ; i ++)
           {
               for(int j = 0 ; j < x ; j ++)
               {
                   a1[i][j] = Integer.parseInt(s2[l]) ; 
                   l ++ ;
               }
           }
       }
       Solution y = new Solution() ;
       int[][] a2 = y.transpose(a1) ;
       System.out.print("[");
       for(int i = 0 ; i < a2.length ; i ++)
       {
           System.out.print("[");
            for(int j = 0 ; j < a2.length ; j ++)
            {
                System.out.print(a2[i][j]) ;
                if(j != a2.length - 1)
                  System.out.print(", ");
            }
            System.out.print("]");
            if(i != a2.length - 1)
                  System.out.print(", ");
        }
       System.out.print("]");
    }
}
