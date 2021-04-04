import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public double average(int[] array) {
        int sum = 0 ;
        for(int i  = 0 ; i < array.length ; i ++)
        {
            sum += array[i] ;
        }
        return (double)sum/array.length ;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        String s1 = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s2 = s1.split(", ") ;
        int[] a = new int[s2.length] ;
        
        if(s2.length == 1 && s2[0].isEmpty())
        {
            System.out.println(0.0);
            return ;
        }
        else
        {
            for(int i = 0 ; i < s2.length ; i ++)
            {
                a[i] = Integer.parseInt(s2[i]) ;
            }
        }
        Solution y = new Solution() ;
        double val = y.average(a) ;
        System.out.println(val);
    }
}
