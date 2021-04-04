import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ICalculator {
    int add(int x, int y);
    float divide(int x, int y) throws RuntimeException ;
}

class Calcuator implements ICalculator{
  public int add(int x , int y)
  {
      System.out.println(x + y);
      return 0 ;
  }
  public float divide(int x , int y)
  {
      if (y == 0){
        throw new RuntimeException() ;
      }else{
        System.out.println((float) x / y);
        return 0;
      }
  }
}

class Solution{
    public static void main(String args[]) {
        Scanner x = new Scanner(System.in) ;
        int one , two ;
        char opr ;
        one = x.nextInt() ;
        opr = x.next().charAt(0) ;
        two = x.nextInt() ;
        Calcuator y = new Calcuator() ;
        
        if(opr == '+')
        {
            y.add(one, two) ;
        }
        else {
            try{
                y.divide(one, two) ;
            }
            catch(RuntimeException e)
            {
                System.out.println("Error") ;     
            }
            
        }
        x.close();
    }
}
