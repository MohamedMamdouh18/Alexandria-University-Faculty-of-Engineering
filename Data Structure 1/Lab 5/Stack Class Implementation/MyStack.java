import java.io.*;
import java.util.Scanner;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {

    /*** Removes the element at the top of stack and returns that element.
     * @return top of stack element, or through exception if empty
     */

    public Object pop();

    /*** Get the element at the top of stack without removing it from stack.
     * @return top of stack element, or through exception if empty
     */

    public Object peek();

    /*** Pushes an item onto the top of this stack.
     * @parainsert*
     **/

    public void push(Object element);

    /*** Tests if this stack is empty
     * @return true if stack empty
     */
    public boolean isEmpty();

    public int size();
}

class Node {
    Object data;
    Node next;

    Node(Object value) {
        data = value;
        next = null;
    }
}

class Stack implements IStack {
    /* Implement your linked list class here*/
    Node top;
    private int size = 0;

    public Object pop() {
        top = top.next ;
        size -- ;
        return null;
    }

    public Object peek() {
        System.out.println(top.data);
        return null;
    }

    public void push(Object element) {
        Node n = new Node(element) ;
        n.next = top ;
        top = n ;
        size ++ ;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print()
    {
        Node n = top ;
        System.out.print("[") ;
        while(n != null)
        {
            System.out.print(n.data) ;
            if(n.next != null)
            {
                System.out.print(", ") ;
            }
            n = n.next ;
        }
        System.out.print("]") ;
    }
}

public class MyStack
{
    public static void main(String[] args)
    {
        Stack list = new Stack();
        Scanner input = new Scanner(System.in) ;
        String x1 = input.nextLine().replaceAll("\\[|\\]" , "") ;
        String[] x2 = x1.split(", ") ;
        int[] x3 = new int[x2.length] ;
        if(!(x2.length == 1 && x2[0].isEmpty()))
        {
            for (int i = 0; i < x2.length; i++)
            {
                x3[i] = Integer.parseInt(x2[i]) ;
            }
            for(int i = 0 ; i < x3.length ; i ++)
            {
                list.push(x3[x3.length-1-i]) ;
            }
        }

        String opr = input.next() ;
        try
        {
            switch (opr)
            {
                case "push" :
                    int num = input.nextInt() ;
                    list.push(num) ;
                    list.print();
                    break;

                case "pop" :
                    list.pop() ;
                    list.print();
                    break;

                case "peek" :
                    list.peek();
                    break;

                case "size" :
                    System.out.println(list.size());
                    break;

                case "isEmpty" :
                    if(list.isEmpty())
                    {
                        System.out.println("True");
                    }
                    else
                    {
                        System.out.println("False");
                    }
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }

}
