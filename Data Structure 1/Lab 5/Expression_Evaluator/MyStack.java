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

interface IExpressionEvaluator {
    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression infix expression
     * @return postfix expression
     */
    public String infixToPostfix(String expression) throws Exception ;

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     * @param expression postfix expression
     * @return the expression evaluated value
     */
    public int evaluate(String expression);
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
        return top.data;
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
}

public class MyStack implements IExpressionEvaluator
{
    Stack right_expression_print = new Stack() ;
    static int a = 0,b = 0,c = 0 ;
    public static void main(String[] args)
    {
        int order = 0;
        Stack A = new Stack();
        Stack B = new Stack();
        Stack C = new Stack();
        Scanner input = new Scanner(System.in) ;
        String expr = input.next() ;

        String var = input.next() ;
        for(int i = 0 ; i < var.length() ; i ++)
        {
            A.push(var.charAt(i));
        }
        while( (char)A.peek() != '=')
        {
            if((char)A.peek() == '-')
            {
                a = -a ;
                break ;
            }
            a += ((char)A.peek()-'0') * Math.pow(10 , order);
            A.pop() ;
            order ++ ;
        }
        order = 0 ;

        var = input.next() ;
        for(int i = 0 ; i < var.length() ; i ++)
        {
            B.push(var.charAt(i));
        }
        while( (char)B.peek() != '=')
        {
            if((char) B.peek() == '-')
            {
                b = -b ;
                break ;
            }
            b += ((char)B.peek()-'0') * Math.pow(10 , order);
            B.pop() ;
            order ++ ;
        }
        order = 0 ;

        var = input.next() ;
        for(int i = 0 ; i < var.length() ; i ++)
        {
            C.push(var.charAt(i));
        }
        while( (char)C.peek() != '=')
        {
            if((char)C.peek() == '-')
            {
                c = -c ;
                break ;
            }
            c += ((char)C.peek()-'0') * Math.pow(10 , order);
            C.pop() ;
            order ++ ;
        }
        if(expr.length() == 2 && expr.charAt(0) != '-')
        {
            System.out.println("Error");
            System.exit(0);
        }
        MyStack obj = new MyStack() ;

        expr = expr.replaceAll("\\+--" , "+") ;
        expr = expr.replaceAll("/--" , "/") ;
        expr = expr.replaceAll("\\^--" , "^") ;
        expr = expr.replaceAll("\\*--" , "*") ;
        expr = expr.replaceAll("--" , "+") ;
        if(expr.charAt(0) == '+')
        {
            expr = expr.replaceFirst( "\\+","");
        }

        for (int i = 0; i < expr.length() - 1; ++i) {
            if ( ((expr.charAt(i) == '/' || expr.charAt(i) == '^' || expr.charAt(i) == '*' || expr.charAt(i) == '-' || expr.charAt(i) == '+') && (expr.charAt(i+1) == '/'||
            expr.charAt(i+1) == '^' || expr.charAt(i+1) == '*'|| expr.charAt(i+1) == '+' || expr.charAt(i+1) == '-'))  ) {
                System.out.println("Error");
                System.exit(0);
            }
        }
        String PostExpr = null;
        try
        {
            PostExpr = obj.infixToPostfix(expr);
        }
        catch (Exception e)
        {
            System.out.println("Error");
            return ;
        }
        int sum = 0 ;
        Stack right_expression_print = new Stack();
        try {
            sum = obj.evaluate(PostExpr) ;
        }
        catch (Exception w)
        {
            System.out.println("Error");
            return ;
        }

        while(!right_expression_print.isEmpty())
        {
            System.out.print(right_expression_print.peek());
            right_expression_print.pop() ;
        }
        System.out.println();
        System.out.println(sum);

    }

    public String infixToPostfix(String expr) throws Exception {
        int peek_order= 0 , in_order = 0 ;

        Stack reverse_expression = new Stack();
        Stack operations = new Stack();
        int flag = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isAlphabetic(expr.charAt(i))) {
                reverse_expression.push(expr.charAt(i));
            } else if (expr.charAt(i) == '(') {
                flag++;
                operations.push(expr.charAt(i));
            } else if (expr.charAt(i) == ')') {
                if (flag == 0) {
                    throw new Exception() ;
                } else {
                    while ((char) operations.peek() != '(') {
                        reverse_expression.push(operations.peek());
                        operations.pop();
                    }
                    operations.pop();
                    flag--;
                }
            } else {
                if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                    in_order = 1;
                } else if (expr.charAt(i) == '*' || expr.charAt(i) == '/') {
                    in_order = 2;
                } else if (expr.charAt(i) == '^') {
                    in_order = 3;
                }

                if (!operations.isEmpty() && ((char) operations.peek() == '+' || (char) operations.peek() == '-')) {
                    peek_order = 1;
                } else if (!operations.isEmpty() && ((char) operations.peek() == '*' || (char) operations.peek() == '/')) {
                    peek_order = 2;
                } else if (!operations.isEmpty() && (char) operations.peek() == '^') {
                    peek_order = 3;
                }

                if (!operations.isEmpty() && peek_order == in_order) {
                    reverse_expression.push(operations.peek());
                    operations.pop();
                    operations.push(expr.charAt(i));
                } else if (!operations.isEmpty() && peek_order > in_order) {
                    while (!operations.isEmpty()) {
                        reverse_expression.push(operations.peek());
                        operations.pop();
                    }
                    if (reverse_expression.size() < 4) {
                        operations.push(expr.charAt(i));
                    } else {
                        reverse_expression.push(expr.charAt(i));
                    }
                } else if (!operations.isEmpty() && peek_order < in_order) {
                    operations.push(expr.charAt(i));
                } else if (operations.isEmpty()) {
                    operations.push(expr.charAt(i));
                }
            }
        }
        if(flag != 0)
        {
            throw new Exception() ;
        }
        while (!operations.isEmpty()) {
            reverse_expression.push(operations.peek());
            operations.pop();
        }
        char[] m = new char[reverse_expression.size()] ;
        while(!reverse_expression.isEmpty())
        {
            m[reverse_expression.size() - 1] = (char)reverse_expression.peek() ;
            reverse_expression.pop() ;
        }
        String n = new String(m) ;
        return n ;
    }

    public int evaluate(String PostExpr) {
        Stack reverse_expression = new Stack();
        Stack right_expression_eval = new Stack();

        for (int i = 0; i < PostExpr.length(); i++) {
            reverse_expression.push(PostExpr.charAt(i));
        }
        while (!reverse_expression.isEmpty()) {
            right_expression_print.push(reverse_expression.peek());
            if ((char) reverse_expression.peek() == 'a') {
                right_expression_eval.push((int) a);
            } else if ((char) reverse_expression.peek() == 'b') {
                right_expression_eval.push((int) b);
            } else if ((char) reverse_expression.peek() == 'c') {
                right_expression_eval.push((int) c);
            } else {
                char y = (char) reverse_expression.peek();
                right_expression_eval.push((int) y);
            }
            reverse_expression.pop();
        }
        while (!right_expression_print.isEmpty()) {
            System.out.print((char) right_expression_print.peek());
            right_expression_print.pop();
        }


        Stack evaluation_stack = new Stack();
        int x;
        int elem1, elem2;
        while (!right_expression_eval.isEmpty()) {
            x = (int) right_expression_eval.peek();
            if ((char) x != '-' && (char) x != '+'
                    && (char) x != '*' && (char) x != '/' && (char) x != '^') {
                evaluation_stack.push(x);
            } else {
                elem2 = (int) evaluation_stack.peek();
                evaluation_stack.pop();

                switch ((char) x) {
                    case '+':
                        if (evaluation_stack.top == null) {
                            evaluation_stack.push((int) elem2);
                        } else {
                            elem1 = (int) evaluation_stack.peek();
                            evaluation_stack.pop();
                            evaluation_stack.push((int) elem2 + elem1);
                        }
                        break;
                    case '-':
                        if (evaluation_stack.top == null) {
                            evaluation_stack.push((int) -elem2);
                        } else {
                            elem1 = (int) evaluation_stack.peek();
                            evaluation_stack.pop();
                            evaluation_stack.push((int) elem1 - elem2);
                        }
                        break;
                    case '*':
                        elem1 = (int) evaluation_stack.peek();
                        evaluation_stack.pop();
                        evaluation_stack.push((int) elem2 * elem1);
                        break;
                    case '/':
                        elem1 = (int) evaluation_stack.peek();
                        evaluation_stack.pop();
                        evaluation_stack.push((int) elem1/elem2 );

                        break;
                    case '^':
                        elem1 = (int) evaluation_stack.peek();
                        evaluation_stack.pop();
                        if(elem2 == -1)
                        {
                            evaluation_stack.push( 0);
                        }
                        else
                        {
                            evaluation_stack.push((int) Math.pow(elem1, elem2));
                        }

                        break;
                }
            }
            right_expression_eval.pop();
        }
        return (int)evaluation_stack.peek() ;
    }
}
