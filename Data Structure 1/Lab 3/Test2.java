import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point ;


interface IPlayersFinder {
    
    Point[] findPlayers(String[] photo, int team, int threshold);
}

public class Test2 implements IPlayersFinder{
    
    static int[][] check ;
    static int size , least_x , least_y , most_x , most_y , point_arr = 0;
    
    public static void find(String[] photo , int i , int j , char req)
    {
        if(j+1 < photo[0].length() && check[i][j + 1] == 0)
        {
            check[i][j + 1] = 1 ;
            if(photo[i].charAt(j + 1) == req)
            {
                size += 4 ;
                if(j < least_x)
                    least_x = j ;
                else if(j + 1 > most_x)
                    most_x = j + 1 ;
                find(photo , i , j+1 , req)  ;      
            }
        }
        if(i+1 < photo.length && check[i + 1][j] == 0)
         {
            check[i + 1][j] = 1 ;
            if(photo[i+1].charAt(j) == req)
            {
                size += 4 ;
                if(i < least_y)
                    least_y = i;
                else if(i+1 > most_y)
                    most_y = i+1 ;
                find(photo , i+1 , j , req)  ;         
            }
        }
        if(i-1 > -1 &&check[i - 1][j] == 0)
        {
            check[i - 1][j] = 1 ;
                if(photo[i-1].charAt(j) == req)
                {
                    size += 4 ;
                    if(i-2 < least_y)
                        least_y = i-2 ;
                    else if(i-1 > most_y)
                        most_y = i-1 ;
                    find(photo , i - 1 , j , req)  ;     
                }
        }
        if(j-1 > -1 && check[i][j - 1] == 0)
        {
            check[i][j - 1] = 1 ;
            if(photo[i].charAt(j-1) == req)
            {
                size += 4 ;
                if(j-2 < least_x)
                    least_x = j-2 ;
                else if(j -1 > most_x)
                    most_x = j -1 ;
                find(photo , i , j - 1 , req)  ;         
            }
        }
        
        return ;
        
    }
    
    public Point[] findPlayers(String[] photo, int team, int threshold)
    {
        
        Point[] x = new Point[2500] ;
        
        char req = (char)(team+'0') ;
        
        for(int i = 0 ; i < photo.length ; i ++)
        {
            for(int j = 0 ; j < photo[0].length() ; j ++)
            {
                
                size = 0 ; most_x = -1 ; most_y = -1 ;
                least_x = 1000000 ; least_y = 1000000 ;
                if(check[i][j] == 0)
                {
                    check[i][j] = 1 ;
                    if(photo[i].charAt(j) == req)
                    {
                        size += 4 ;
                        least_y = i-1 ;
                        most_y = i ;
                        least_x = j-1 ;
                        most_x = j  ;
                        find(photo , i , j , req)  ; 
                        if(size >= threshold)
                        {
                            x[point_arr] = new Point(least_x+most_x+2 , least_y+most_y+2) ;
                            point_arr ++ ;
                        }
                        
                    }
                }
            }
        }
        return x ;
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in) ;
        
        String[] in = input.nextLine().split(", ") ;
        int row = Integer.parseInt(in[0]) ;
        int col = Integer.parseInt(in[1]) ;
        String[] picture = new String[row] ;
        for(int i = 0 ; i < row ; i ++)
        {
            picture[i] = input.nextLine() ;
        }
        
        int team = input.nextInt() ;
        int threshold = input.nextInt() ;
        if(row == 0 || col == 0)
        {
            System.out.print("[]");
            return ;
        }
        check = new int[picture.length][picture[0].length()] ;
        Test2 y = new Test2() ;
        Point[] x = y.findPlayers(picture ,team , threshold ) ;
        
        int temp ;
        for(int i = 0 ; i < point_arr ; i ++)
        {
            for(int j = 0 ; j < point_arr - 1 ; j ++)
            {
                if(x[j].x > x[j+1].x)
                {
                    temp = x[j].x ;
                    x[j].x = x[j+1].x ;
                    x[j+1].x = temp ;
                    temp = x[j].y ;
                    x[j].y = x[j+1].y ;
                    x[j+1].y = temp ;
                }
                else if(x[j].x == x[j+1].x)
                {
                    if(x[j].y > x[j+1].y)
                    {
                        temp = x[j].x ;
                        x[j].x = x[j+1].x ;
                        x[j+1].x = temp ;
                        temp = x[j].y ;
                        x[j].y = x[j+1].y ;
                        x[j+1].y = temp ;
                    }
                }
            }
        }
        System.out.print("[");
        for(int i = 0 ; i < point_arr ; i ++)
        {
            System.out.print("(" + x[i].x +", " + x[i].y + ")");
            if(i != point_arr -1)
            {
                System.out.print(", ") ;
            }
        }
        System.out.println("]");
    }
}
