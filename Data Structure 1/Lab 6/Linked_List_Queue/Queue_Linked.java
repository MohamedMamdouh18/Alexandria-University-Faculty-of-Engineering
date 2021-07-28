import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
    /* Inserts an item at the queue front.*/
    public void enqueue(Object item);
    /* Removes the object at the queue rear and returnsit.*/
    public Object dequeue();
    /* Tests if this queue is empty.*/
    public boolean isEmpty();
    /* Returns the number of elements in the queue*/
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

class Queue implements IQueue {
    Node head , tail;
    private int size = 0;

    public Object dequeue() {
        Object temp = tail.data ;
        if(size == 1)
        {
            head = null ;
            tail = null ;
        }
        else
        {
            Node n = head ;
            while(n.next != tail) n = n.next ;
            n.next = null ;
            tail = n ;
        }
        size -- ;
        return temp ;
    }

    public void enqueue(Object element) {
        Node n = new Node(element) ;
        if(size == 0 )
        {
            head = n ;
            tail = head ;
        }
        else
        {
            n.next = head ;
            head = n ;
        }
        size ++ ;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.print("[");
        Node n = head ;
        while(n != null)
        {
            System.out.print(n.data);
            if(n.next != null)System.out.print(", ");
            n = n.next ;
        }
        System.out.println("]");
    }
}

public class Queue_Linked {
    public static void main(String[] args) {
        Queue q = new Queue() ;

        Scanner input = new Scanner(System.in) ;
        String s1 = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s2 = s1.split(", ") ;

        if(!(s2.length == 1 && s2[0].isEmpty()))
        {
            for(int i = s2.length-1 ; i >= 0 ; i --)
            {
                q.enqueue(Integer.parseInt(s2[i]));
            }
        }

        String opr = input.next() ;
        try
        {
            switch (opr)
            {
                case "enqueue" :
                    int num = input.nextInt() ;
                    q.enqueue(num);
                    q.print();
                    break;

                case "dequeue" :
                    q.dequeue();
                    q.print();
                    break;

                case "size" :
                    System.out.println(q.size());
                    break ;

                case "isEmpty" :
                    if(q.isEmpty())
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
