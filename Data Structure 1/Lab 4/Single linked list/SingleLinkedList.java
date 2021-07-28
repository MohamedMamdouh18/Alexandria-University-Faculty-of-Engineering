package com.company;


import java.io.*;
import java.util.Scanner;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index
     * @param element
     */
    public void addToIndex(int index, Object element);

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element
     */
    public void add(Object element);

    /**
     * @param index
     * @return the element at the specified position in this list.
     */
    public Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index
     * @param element
     */
    public void set(int index, Object element);

    /**
     * Removes all of the elements from this list.
     */
    public void clear();

    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index
     */
    public void remove(int index);

    /**
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * @param fromIndex
     * @param toIndex
     * @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
     */
    public ILinkedList sublist(int fromIndex, int toIndex);

    /**
     * @param o
     * @return true if this list contains an element with the same value as the specified element.
     */
    public boolean contains(Object o);
}

class Node{
    Object data;
    Node next;

    Node(Object value) {
        data = value;
        next = null;
    }
}

public class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/
    Node head;
    static int size = 0;
    static SingleLinkedList singleList = new SingleLinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] list_new = list.split(", ");
        String opr = sc.next();

        if (!(list_new[0].isEmpty() && list_new.length == 1)) {
            for (int i = 0; i < list_new.length; i++) {
                Node n = new Node(Integer.parseInt(list_new[i]));
                if (singleList.head == null) {
                    size++;
                    singleList.head = n;
                } else {
                    Node current = singleList.head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    size++;
                    current.next = n;
                }
            }
        }
        try {
            switch (opr) {
                case "get": {
                    int index = sc.nextInt();
                    if (index > size - 1 || index < 0) {
                        System.out.println("Error");
                    } else {
                        singleList.get(index);
                    }
                    break;
                }
                case "addToIndex": {
                    int index1 = sc.nextInt();
                    Object index2 = sc.nextInt();
                    if (index1 < 0 || index1 > size) {
                        System.out.println("Error");
                    } else {
                        singleList.addToIndex(index1, index2);
                        singleList.prints(singleList);
                    }
                    break;
                }
                case "add": {
                    int index = sc.nextInt();
                    singleList.add(index);
                    singleList.prints(singleList);
                    break;
                }
                case "set": {
                    int index1 = sc.nextInt();
                    Object index2 = sc.nextInt();
                    if (index1 > size - 1 || index1 < 0) {
                        System.out.println("Error");
                    } else {
                        singleList.set(index1, index2);
                        singleList.prints(singleList);
                    }
                    break;
                }
                case "clear":
                    singleList.clear();
                    singleList.prints(singleList);
                    break;
                case "isEmpty":
                    if (singleList.isEmpty()) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "remove": {
                    int index = sc.nextInt();
                    if (index > size - 1 || index < 0) {
                        System.out.println("Error");
                    } else {
                        singleList.remove(index);
                        singleList.prints(singleList);
                    }
                    break;
                }
                case "size":
                    System.out.println(singleList.size());
                    break;
                case "sublist": {
                    int index1 = sc.nextInt();
                    int index2 = sc.nextInt();
                    if (index1 > size - 1 || index2 > size - 1 || index1 < 0 || index2 < 0 || index1 > index2) {
                        System.out.println("Error");
                    } else {
                        singleList.sublist(index1, index2);
                    }
                    break;
                }
                case "contains":
                    Object i = sc.nextInt();
                    if (singleList.contains(i)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }

    public void addToIndex(int index, Object element) {
        int counter = 0;
        Node elem = new Node(element);
        if (counter == index) {
            if (singleList.head == null) {
                singleList.head = elem;
            } else {
                Node curr = singleList.head;
                singleList.head = elem;
                singleList.head.next = curr;
            }
        } else {
            counter++;
            Node current = singleList.head;
            while (counter != index) {
                current = current.next;
                counter++;
            }
            elem.next = current.next;
            current.next = elem;
        }
        size++;
    }

    public void add(Object element) {
        Node n = new Node(element);
        if (singleList.head == null) {
            singleList.head = n;
        } else {
            Node current = singleList.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
        size++;
    }

    public Object get(int index) {
        int num = 0;

        Node n = singleList.head;
        while (num != index) {
            num++;
            n = n.next;
        }

        System.out.println(n.data);

        return null;
    }

    public void set(int index, Object element) {
        int num = 0;
        Node n = singleList.head;
        while (n.next != null && num != index) {
            num++;
            n = n.next;
        }

        if (num != index) {
            System.out.println("Error");
        } else {
            n.data = element;
        }

    }

    public void clear() {
        singleList.head = null;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public void remove(int index) {
        int counter = 0;
        if (counter == index) {
            if (singleList.head == null) {
                System.out.println("Error");
            } else {
                singleList.head = singleList.head.next;
            }
        } else {
            counter++;
            Node current = singleList.head;
            while (counter != index) {
                current = current.next;
                counter++;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public ILinkedList sublist(int fromIndex, int toIndex) {
        int num = 0;
        Node n = singleList.head;
        SingleLinkedList sublist = new SingleLinkedList();
        if (fromIndex == toIndex && toIndex == size - 1) {
            while (n != null) {
                if (num == fromIndex) {
                    sublist.head = n;
                    break;
                }
                num++;
                n = n.next;
            }
        } else {
            while (n.next != null) {
                if (num == fromIndex) {
                    sublist.head = n;
                    break;
                }
                num++;
                n = n.next;
            }
            int length = toIndex - fromIndex;
            while (length != 0) {
                n = n.next;
                length--;
            }
            n.next = null;
        }
        sublist.prints(sublist);
        return null;
    }

    public boolean contains(Object o) {
        Node n = singleList.head;
        while (n.next != null) {
            if (n.data == o) {
                return true;
            } else {
                n = n.next;
            }
        }
        if(n.data == o)
        {
            return true;
        }
        return false;
    }

    public void prints(SingleLinkedList singleList) {
        System.out.print("[");
        while (singleList.head != null) {
            if (singleList.head.next != null) {
                System.out.print(singleList.head.data + ", ");
            } else {
                System.out.print(singleList.head.data);
            }
            singleList.head = singleList.head.next;
        }
        System.out.print("]");
    }
}
