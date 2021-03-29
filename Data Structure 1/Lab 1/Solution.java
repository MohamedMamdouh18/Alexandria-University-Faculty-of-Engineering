import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ICalculator {
    /**
    * Adds given two numbers
    * @param x first number
    * @param y second number
    * @return the sum of the two numbers
    */
    int add(int x, int y);
    /**
    * Divides two numbers
    * @param x first number
    * @param y second number
    * @return the division result
    */
    float divide(int x, int y) throws RuntimeException;
}

class Calcuator implements ICalculator{
  /* Implement your calculator class here*/
  public int add(int x , int y)
  {
      return x + y ;
  }
  public float divide(int x , int y)
  {
      float f = (float)x / y ;
      return f ;
  }
}

class Solution{
    public static void main(String args[]) {
        Scanner x = new Scanner(System.in) ;
        int one , two , ans1 ;
        float ans2 ;
        char opr ;
        one = x.nextInt() ;
        opr = x.next().charAt(0) ;
        two = x.nextInt() ;
        Calcuator y = new Calcuator() ;
        
        if(opr == '+')
        {
            ans1 = y.add(one, two) ;
            System.out.println(ans1) ;
        }
        else {
            if(two == 0)
            {
                System.out.println("Error") ;
            }
            else {
                ans2 = y.divide(one, two) ;
                System.out.println(ans2) ;
            }
        }
        x.close();
    }
}
