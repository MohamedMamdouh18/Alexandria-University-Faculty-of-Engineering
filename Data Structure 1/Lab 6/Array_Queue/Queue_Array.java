import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {

    /**
     * Inserts an item at the queue front.
     */
    public void enqueue(Object item);

    /**
     * Removes the object at the queue rear and returns it.
     */
    public Object dequeue() throws Exception;

    /**
     * Tests if this queue is empty.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue
     */
    public int size();
}

class Queue implements IQueue {
    private int size = 0, front, rear;
    int[] arr = new int[100];

    public void Queue() {
        rear = -1;
        front = -1;
    }

    public void enqueue(Object item) {
        arr[rear] = (int) item;
        rear++;
        size++;
    }

    public Object dequeue() {
        if (!isEmpty()) {
            int temp = arr[front];
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            size--;
            return temp;
        }
        throw new EmptyStackException();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.print("[");
        for (int i = front; i < rear; i++) {
            if (i != rear - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}

public class Queue_Array {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("[\\[\\]]", "");
        String[] newS = sin.split(", ");
        int[] arr = new int[newS.length];
        if (!(newS.length == 1 && newS[0].isEmpty())) {
            for (int i = 0; i < newS.length; i++) {
                arr[i] = Integer.parseInt(newS[i]);
            }
            for (int i = 0; i < arr.length; i++) {
                queue.enqueue(arr[i]);
            }
        }
        while (sc.hasNext()) {
            String opr = sc.next();
            try {
                switch (opr) {
                    case "enqueue":
                        int num = sc.nextInt();
                        queue.enqueue(num);
                        queue.print();
                        break;

                    case "dequeue":
                        System.out.println(queue.dequeue());
                        break;

                    case "size":
                        System.out.println(queue.size());
                        break;

                    case "isEmpty":
                        if (queue.isEmpty()) {
                            System.out.println("True");
                        } else {
                            System.out.println("False");
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error");
                System.exit(0);
            }
        }
    }
}
