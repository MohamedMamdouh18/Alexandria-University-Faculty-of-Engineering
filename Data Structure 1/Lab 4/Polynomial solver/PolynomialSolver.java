package com.company;

import java.util.Scanner;

import static java.lang.Math.pow;

interface IPolynomialSolver {
    /**
     * Set polynomial terms (coefficients & exponents)
     *
     * @param poly:  name of the polynomial
     * @param terms: array of [coefficients][exponents]
     */
    void setPolynomial(char poly, int[][] terms) throws RuntimeException;

    /**
     * Print the polynomial in ordered human readable representation
     *
     * @param poly: name of the polynomial
     * @return polynomial in the form like 27x^2+x-1
     */
    String print(char poly) throws RuntimeException;

    /**
     * Clear the polynomial
     *
     * @param poly: name of the polynomial
     */
    void clearPolynomial(char poly) throws RuntimeException;

    /**
     * Evaluate the polynomial
     *
     * @param poly:  name of the polynomial
     * @param value: the polynomial constant value
     * @return the value of the polynomial
     */
    float evaluatePolynomial(char poly, float value) throws RuntimeException;

    /**
     * Add two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[][] add(char poly1, char poly2) throws RuntimeException;

    /**
     * Subtract two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[][] subtract(char poly1, char poly2) throws RuntimeException;

    /**
     * Multiply two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return: the result polynomial
     */
    int[][] multiply(char poly1, char poly2) throws RuntimeException;
}

interface ILinkedList {
    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index
     * @param element1
     * @param element2
     */
    void addToIndex(int index, Object element1, Object element2);

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element1
     * @param element2
     */
    void add(Object element1, Object element2);

    /**
     * @param index
     * @return the element at the specified position in this list.
     */
    Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index
     * @param element1
     * @param element2
     */
    void set(int index, Object element1, Object element2);

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * @return true if this list contains no elements.
     */
    boolean isEmpty();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index
     */
    void remove(int index);

    /**
     * @return the number of elements in this list.
     */
    int size();

    /**
     * @param fromIndex
     * @param toIndex
     * @return a view of the portion of this list between
     * the specified fromIndex and toIndex, inclusively.
     */
    ILinkedList sublist(int fromIndex, int toIndex);

    /**
     * @param o
     * @return true if this list contains an element
     * with the same value as the specified element.
     */
    boolean contains(Object o);
}

class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/
    Node head;
    int size = 0;

    public static class Node {
        Object coff;
        Object exp;
        Node next;

        Node(Object value1, Object value2) {
            coff = value1;
            exp = value2;
            next = null;
        }
    }

    public void addToIndex(int index, Object element1, Object element2) {
        int counter = 0;
        Node elem = new Node(element1, element2);
        if (counter == index) {
            if (head == null) {
                head = elem;
            } else {
                Node curr = head;
                head = elem;
                head.next = curr;
            }
        } else {
            counter++;
            Node current = head;
            while (counter != index) {
                current = current.next;
                counter++;
            }
            elem.next = current.next;
            current.next = elem;
        }
        size++;
    }

    public void add(Object element1, Object element2) {
        Node n = new Node(element1, element2);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
        size++;
    }

    public Object get(int index) {
        int num = 0;

        Node n = head;
        while (num != index) {
            num++;
            n = n.next;
        }

        System.out.println(n.coff);

        return null;
    }

    public void set(int index, Object element1, Object element2) {
        int num = 0;
        Node n = head;
        while (n.next != null && num != index) {
            num++;
            n = n.next;
        }

        if (num != index) {
            System.out.println("Error");
        } else {
            n.coff = element1;
            n.exp = element2;
        }

    }

    public void clear() {
        size = 0;
        head = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        int counter = 0;
        if (counter == index) {
            if (head == null) {
                System.out.println("Error");
            } else {
                head = head.next;
            }
        } else {
            counter++;
            Node current = head;
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
        Node n = head;
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
        //sublist.prints(sublist);
        return null;
    }

    public boolean contains(Object o) {
        Node n = head;
        while (n.next != null) {
            if (n.coff == o) {
                return true;
            } else {
                n = n.next;
            }
        }
        return n.coff == o;
    }
}

public class Polynomial_Solver implements IPolynomialSolver {
    static SingleLinkedList A = new SingleLinkedList(); //initialize the 3 lists and R which we will store the results of add-subtract-multiply
    static SingleLinkedList B = new SingleLinkedList();
    static SingleLinkedList C = new SingleLinkedList();
    static SingleLinkedList R = new SingleLinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polynomial_Solver bazina = new Polynomial_Solver();

        while (sc.hasNext()) {//running the program while the inputs is coming
            String opr = sc.next();
            try {
                if (!opr.equals("set") && !opr.equals("print") //check for the input operation if it something different then print error
                        && !opr.equals("clear") && !opr.equals("add")
                        && !opr.equals("sub") && !opr.equals("mult")
                        && !opr.equals("eval")) {
                    throw new RuntimeException("Error");
                }
            } catch (RuntimeException e2) {
                System.out.println("Error");
                System.exit(0);
            }
            char name, name1, name2;
            try {
                switch (opr) {//switch for the operation
                    case "set": {
                        name = sc.next().charAt(0);
                        if ((name != 'A') && (name != 'B') && (name != 'C')) {//check if the name is one of out lists or print error
                            throw new RuntimeException("Error");
                        }
                        String arr = sc.next().replaceAll("[\\[\\]]", "");
                        try { // check if the iput is right or not
                            if (arr.charAt(arr.length() - 1) == ',') {
                                throw new RuntimeException("Error");
                            }
                        } catch (RuntimeException e3) {
                            System.out.println("Error");
                            System.exit(0);
                        }
                        String[] arr_new = arr.split(",");
                        int[][] x = new int[arr_new.length][2];

                        if (!(arr_new.length == 1 && arr_new[0].isEmpty())) {//check if the input is empty
                            for (int i = 0; i < arr_new.length; i++) {//assign the input to 2d array
                                x[i][0] = Integer.parseInt(arr_new[i]);
                                x[i][1] = arr_new.length - 1 - i;
                            }
                        }
                        bazina.setPolynomial(name, x);//assign the input to the desired list
                        break;
                    }
                    case "print": {
                        name = sc.next().charAt(0);
                        if ((name != 'A' || A.size == 0) &&//check if the name is one of out lists or print error & if the desired list is empty or not
                                (name != 'B' || B.size == 0)
                                && (name != 'C' || C.size == 0)) {
                            throw new RuntimeException("Error");
                        }
                        bazina.print(name);
                        System.out.print("\n");
                        break;
                    }
                    case "clear": {//clear the desired list
                        name = sc.next().charAt(0);
                        if ((name != 'A') && (name != 'B') && (name != 'C')) {//check if the name is one of out lists or print error
                            throw new RuntimeException("Error");
                        }
                        bazina.clearPolynomial(name);
                        System.out.println("[]");
                        break;
                    }
                    case "eval": {
                        name = sc.next().charAt(0);
                        if ((name != 'A' || A.size == 0) &&//check if the name is one of out lists or print error & if the desired list is empty or not
                                (name != 'B' || B.size == 0)
                                && (name != 'C' || C.size == 0)) {
                            throw new RuntimeException("Error");
                        }
                        float num = sc.nextFloat();
                        float res = bazina.evaluatePolynomial(name, num);
                        System.out.println((int) res);
                        break;
                    }
                    case "add": {
                        name1 = sc.next().charAt(0);
                        name2 = sc.next().charAt(0);
                        if ((name1 != 'A') && (name1 != 'B') && (name1 != 'C')//check if the names is two of out lists or print error
                                && (name2 != 'A') && (name2 != 'B')
                                && (name2 != 'C')) {
                            throw new RuntimeException("Error");
                        }
                        int[][] res_add = bazina.add(name1, name2);
                        bazina.setPolynomial('R', res_add);//set the result to a new list
                        bazina.print('R');//print the result
                        bazina.add(name1, name2);
                        break;
                    }
                    case "sub": {
                        name1 = sc.next().charAt(0);
                        name2 = sc.next().charAt(0);
                        if ((name1 != 'A') && (name1 != 'B') && (name1 != 'C')//check if the names is two of out lists or print error
                                && (name2 != 'A') && (name2 != 'B')
                                && (name2 != 'C')) {
                            throw new RuntimeException("Error");
                        }
                        int[][] res_sub = bazina.subtract(name1, name2);
                        bazina.setPolynomial('R', res_sub);//set the result to a new list
                        bazina.print('R');//print the result
                        System.out.print("\n");
                        break;
                    }
                    case "mult": {
                        name1 = sc.next().charAt(0);
                        name2 = sc.next().charAt(0);
                        if ((name1 != 'A') && (name1 != 'B') && (name1 != 'C')//check if the names is two of out lists or print error
                                && (name2 != 'A') &&
                                (name2 != 'B') && (name2 != 'C')) {
                            throw new RuntimeException("Error");
                        }
                        int[][] res_mult = bazina.multiply(name1, name2);
                        bazina.setPolynomial('R', res_mult);//set the result to a new list
                        bazina.print('R');//print the result
                        System.out.print("\n");
                        break;
                    }
                }
            } catch (RuntimeException e1) {
                System.out.println("Error");
                System.exit(0);
            }
        }
    }

    public void setPolynomial(char poly, int[][] terms) {//adding the numbers(exp and coff) of the 2d array to the list by using add method
        //first we clean it to re-set the list
        if (poly == 'A') {
            A.clear();
            for (int[] term : terms) {
                A.add(term[0], term[1]);
            }
        } else if (poly == 'B') {
            B.clear();
            for (int[] term : terms) {
                B.add(term[0], term[1]);
            }
        } else if (poly == 'C') {
            C.clear();
            for (int[] term : terms) {
                C.add(term[0], term[1]);
            }
        } else {
            R.clear();
            for (int[] term : terms) {
                R.add(term[0], term[1]);
            }
        }
    }

    public String print(char poly) { //printing the list
        switch (poly) {//checking for the list name
            case 'A': {
                int counter = 0, zero = 0;
                SingleLinkedList.Node curr = A.head;//making variable point to the head of the list
                while ((int) curr.coff == 0) {//check if the first elements coff is zeros so don't print these terms and skip them
                    curr = curr.next;
                }
                while (curr != null) {
                    if (counter > 0 && (int) curr.coff > 0) {//checking for the counter of printed terms to print "+"
                        System.out.print("+");
                    }
                    if ((int) curr.coff == 0) {//if the coff is zero don't print something
                        curr = curr.next;
                        zero++;
                        counter++;
                        continue;
                    } else if ((int) curr.coff == 1) {//if the coff is 1
                        if ((int) curr.exp != 0 && (int) curr.exp != 1) {//exp don't equal 1 or 0 print the terms without coff
                            System.out.print("x^" + curr.exp);
                        } else if ((int) curr.exp == 1) {//exp equal 1 print x only
                            System.out.print("x");
                        } else {//exp equal 0 then print 1
                            System.out.print(curr.coff);
                        }
                    } else if ((int) curr.exp == 0) {//exp equal 0 then print the coff
                        System.out.print(curr.coff);
                    } else if ((int) curr.exp == 1) {//exp equal 1 print x with the coff
                        System.out.print(curr.coff + "x");
                    } else {
                        System.out.print(curr.coff + "x^" + curr.exp); // general state print the full term (coff with exp)
                    }
                    curr = curr.next;//going for next value
                    counter++;
                }
                if (zero == A.size) {//if there is not any value in the list
                    System.out.print("0");
                }
                break;
            }
            case 'B': {
                int counter = 0, zero = 0;
                SingleLinkedList.Node curr = B.head;
                while ((int) curr.coff == 0) {
                    curr = curr.next;
                }
                while (curr != null) {
                    if (counter > 0 && (int) curr.coff > 0) {
                        System.out.print("+");
                    }
                    if ((int) curr.coff == 0) {
                        curr = curr.next;
                        zero++;
                        counter++;
                        continue;
                    } else if ((int) curr.coff == 1) {
                        if ((int) curr.exp != 0 && (int) curr.exp != 1) {
                            System.out.print("x^" + curr.exp);
                        } else if ((int) curr.exp == 1) {
                            System.out.print("x");
                        } else {
                            System.out.print(curr.coff);
                        }
                    } else if ((int) curr.exp == 0) {
                        System.out.print(curr.coff);
                    } else if ((int) curr.exp == 1) {
                        System.out.print(curr.coff + "x");
                    } else {
                        System.out.print(curr.coff + "x^" + curr.exp);
                    }
                    curr = curr.next;
                    counter++;
                }
                if (zero == B.size) {
                    System.out.print("0");
                }
                break;
            }
            case 'C': {
                int counter = 0, zero = 0;
                SingleLinkedList.Node curr = C.head;
                while ((int) curr.coff == 0) {
                    curr = curr.next;
                }
                while (curr != null) {
                    if (counter > 0 && (int) curr.coff > 0) {
                        System.out.print("+");
                    }
                    if ((int) curr.coff == 0) {
                        curr = curr.next;
                        zero++;
                        counter++;
                        continue;
                    } else if ((int) curr.coff == 1) {
                        if ((int) curr.exp != 0 && (int) curr.exp != 1) {
                            System.out.print("x^" + curr.exp);
                        } else if ((int) curr.exp == 1) {
                            System.out.print("x");
                        } else {
                            System.out.print(curr.coff);
                        }
                    } else if ((int) curr.exp == 0) {
                        System.out.print(curr.coff);
                    } else if ((int) curr.exp == 1) {
                        System.out.print(curr.coff + "x");
                    } else {
                        System.out.print(curr.coff + "x^" + curr.exp);
                    }
                    curr = curr.next;
                    counter++;
                }
                if (zero == C.size) {
                    System.out.print("0");
                }
                break;
            }
            case 'R': {
                int counter = 0, zero = 0;
                SingleLinkedList.Node curr = R.head;
                while ((int) curr.coff == 0) {
                    curr = curr.next;
                }
                while (curr != null) {
                    if (counter > 0 && (int) curr.coff > 0) {
                        System.out.print("+");
                    }
                    if ((int) curr.coff == 0) {
                        curr = curr.next;
                        zero++;
                        counter++;
                        continue;
                    } else if ((int) curr.coff == 1) {
                        if ((int) curr.exp != 0 && (int) curr.exp != 1) {
                            System.out.print("x^" + curr.exp);
                        } else if ((int) curr.exp == 1) {
                            System.out.print("x");
                        } else {
                            System.out.print(curr.coff);
                        }
                    } else if ((int) curr.exp == 0) {
                        System.out.print(curr.coff);
                    } else if ((int) curr.exp == 1) {
                        System.out.print(curr.coff + "x");
                    } else {
                        System.out.print(curr.coff + "x^" + curr.exp);
                    }
                    curr = curr.next;
                    counter++;
                }
                if (zero == R.size) {
                    System.out.print("0");
                }
                break;
            }
        }
        return null;
    }

    public void clearPolynomial(char poly) { //clear the named list using the clear method for the object
        if (poly == 'A') {
            A.clear();
        } else if (poly == 'B') {
            B.clear();
        } else {
            C.clear();
        }
    }

    public float evaluatePolynomial(char poly, float value) {//function evaluate the polynomial for the taking number
        SingleLinkedList.Node n;
        float num = 0;
        if (poly == 'A') {//check for the parameter name
            n = A.head;
            while (n != null) {
                num += (float) ((int) n.coff * pow(value, (int) n.exp));//going through the list and evaluating
                n = n.next;
            }
        } else if (poly == 'B') {
            n = B.head;
            while (n != null) {
                num += (float) ((int) n.coff * pow(value, (int) n.exp));
                n = n.next;
            }
        } else if (poly == 'C') {
            n = C.head;
            while (n != null) {
                num += (float) ((int) n.coff * pow(value, (int) n.exp));
                n = n.next;
            }
        } else if (poly == 'R') {
            n = R.head;
            while (n != null) {
                num += (float) ((int) n.coff * pow(value, (int) n.exp));
                n = n.next;
            }
        }
        return num;//return the evaluation sum
    }

    public int[][] add(char poly1, char poly2) { //function adds 2 lists and store in 2 dim array
        int[][] add_arr;//initialize 2 dim array to store value
        if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {//check for the parameters names
            int m_size = Math.max(A.size(), B.size());//number of columns of 2 dim array is number of longest list

            add_arr = new int[m_size][2];
            SingleLinkedList.Node a = A.head;
            SingleLinkedList.Node b = B.head;

            for (int i = 0; i < m_size; i++) {
                if (a.exp == b.exp) {//add numbers according to the exponent
                    add_arr[i][0] = (int) a.coff + (int) b.coff;
                    add_arr[i][1] = (int) a.exp;
                    a = a.next;
                    b = b.next;
                }
                //if exponent is different store the bigger
                else if ((int) a.exp > (int) b.exp) {
                    add_arr[i][0] = (int) a.coff;
                    add_arr[i][1] = (int) a.exp;
                    a = a.next;
                } else if ((int) a.exp < (int) b.exp) {
                    add_arr[i][0] = (int) b.coff;
                    add_arr[i][1] = (int) b.exp;
                    b = b.next;
                }

            }
        } else if ((poly1 == 'C' && poly2 == 'B')
                || (poly1 == 'B' && poly2 == 'C')) {
            int m_size = Math.max(C.size(), B.size());
            add_arr = new int[m_size][2];
            SingleLinkedList.Node c = C.head;
            SingleLinkedList.Node b = B.head;

            for (int i = 0; i < m_size; i++) {
                if (c.exp == b.exp) {
                    add_arr[i][0] = (int) c.coff + (int) b.coff;
                    add_arr[i][1] = (int) c.exp;
                    c = c.next;
                    b = b.next;
                } else if ((int) c.exp > (int) b.exp) {
                    add_arr[i][0] = (int) c.coff;
                    add_arr[i][1] = (int) c.exp;
                    c = c.next;
                } else if ((int) c.exp < (int) b.exp) {
                    add_arr[i][0] = (int) b.coff;
                    add_arr[i][1] = (int) b.exp;
                    b = b.next;
                }
            }
        } else {
            int m_size = Math.max(A.size(), C.size());

            add_arr = new int[m_size][2];
            SingleLinkedList.Node a = A.head;
            SingleLinkedList.Node c = C.head;

            for (int i = 0; i < m_size; i++) {
                if (a.exp == c.exp) {
                    add_arr[i][0] = (int) a.coff + (int) c.coff;
                    add_arr[i][1] = (int) a.exp;
                    a = a.next;
                    c = c.next;
                } else if ((int) a.exp > (int) c.exp) {
                    add_arr[i][0] = (int) a.coff;
                    add_arr[i][1] = (int) a.exp;
                    a = a.next;
                } else if ((int) a.exp < (int) c.exp) {
                    add_arr[i][0] = (int) c.coff;
                    add_arr[i][1] = (int) c.exp;
                    c = c.next;
                }

            }
        }
        return add_arr;// return the 2dim array
    }

    public int[][] subtract(char poly1, char poly2) { //function subtracts 2 lists and store in 2 dim array
        int[][] sub_arr = new int[0][]; //initialize 2 dim array to store value
        if ((poly1 == 'A' && poly2 == 'B') || (poly2 == 'A' && poly1 == 'B')) {//check for the parameters names
            sub_arr = new int[A.size()][2]; //number of columns of 2 dim array is the number of any list
            SingleLinkedList.Node currA = A.head;
            SingleLinkedList.Node currB = B.head;
            for (int i = 0; i < sub_arr.length; i++) {
                if (poly1 == 'B') { //determine which will we add the negative sign to
                    sub_arr[i][0] = (int) currB.coff - (int) currA.coff;
                } else {
                    sub_arr[i][0] = (int) currA.coff - (int) currB.coff;
                }
                sub_arr[i][1] = (int) currA.exp; //store exponent value
                currA = currA.next;//getting next value
                currB = currB.next;//getting next value
            }
        } else if ((poly1 == 'A' && poly2 == 'C')
                || (poly2 == 'A' && poly1 == 'C')) {
            sub_arr = new int[A.size()][2];
            SingleLinkedList.Node currA = A.head;
            SingleLinkedList.Node currC = C.head;
            for (int i = 0; i < sub_arr.length; i++) {
                if (poly1 == 'C') {
                    sub_arr[i][0] = (int) currC.coff - (int) currA.coff;
                } else {
                    sub_arr[i][0] = (int) currA.coff - (int) currC.coff;
                }
                sub_arr[i][1] = (int) currA.exp;
                currA = currA.next;
                currC = currC.next;
            }
        } else if ((poly1 == 'C' && poly2 == 'B')
                || (poly2 == 'C' && poly1 == 'B')) {
            sub_arr = new int[B.size()][2];
            SingleLinkedList.Node currC = C.head;
            SingleLinkedList.Node currB = B.head;
            for (int i = 0; i < sub_arr.length; i++) {
                if (poly1 == 'C') {
                    sub_arr[i][0] = (int) currC.coff - (int) currB.coff;
                } else {
                    sub_arr[i][0] = (int) currB.coff - (int) currC.coff;
                }
                sub_arr[i][1] = (int) currC.exp;
                currB = currB.next;
                currC = currC.next;
            }
        }
        return sub_arr; // return the 2dim array
    }

    public int[][] multiply(char poly1, char poly2) { //function multiplies 2 lists and store in 2 dim array
        int[][] mult_arr = new int[0][];
        if ((poly1 == 'A' && poly2 == 'B') || (poly2 == 'A' && poly1 == 'B')) { //check for the parameters names
            int size = (int) A.head.exp + (int) B.head.exp + 1;  //number of columns of 2 dim array
            mult_arr = new int[size][2]; //initialize 2 dim array to store value
            SingleLinkedList.Node a = A.head;
            for (int i = 0; i < A.size(); i++) { // nested loop to multiply the 2 lists
                SingleLinkedList.Node b = B.head;
                for (int j = 0; j < B.size(); j++) {
                    int result = (int) a.coff * (int) b.coff;
                    int exp = (int) a.exp + (int) b.exp;
                    mult_arr[size - exp - 1][0] += result; //accumulation sum for the result in first row
                    mult_arr[size - exp - 1][1] = exp; //the exponent of the result in second row
                    b = b.next;
                }
                a = a.next;
            }
        } else if ((poly1 == 'A' && poly2 == 'C')
                || (poly2 == 'A' && poly1 == 'C')) {
            int size = (int) A.head.exp + (int) C.head.exp + 1;
            mult_arr = new int[size][2];
            SingleLinkedList.Node a = A.head;
            for (int i = 0; i < A.size(); i++) {
                SingleLinkedList.Node c = C.head;
                for (int j = 0; j < C.size(); j++) {
                    int result = (int) a.coff * (int) c.coff;
                    int exp = (int) a.exp + (int) c.exp;
                    mult_arr[size - exp - 1][0] += result;
                    mult_arr[size - exp - 1][1] = exp;
                    c = c.next;
                }
                a = a.next;
            }
        } else if ((poly1 == 'C' && poly2 == 'B')
                || (poly2 == 'C' && poly1 == 'B')) {
            int size = (int) C.head.exp + (int) B.head.exp + 1;
            mult_arr = new int[size][2];
            SingleLinkedList.Node c = C.head;
            for (int i = 0; i < C.size(); i++) {
                SingleLinkedList.Node b = B.head;
                for (int j = 0; j < B.size(); j++) {
                    int result = (int) c.coff * (int) b.coff;
                    int exp = (int) c.exp + (int) b.exp;
                    mult_arr[size - exp - 1][0] += result;
                    mult_arr[size - exp - 1][1] = exp;
                    b = b.next;
                }
                c = c.next;
            }

        }
        return mult_arr; //return the 2 dim array
    }
}
