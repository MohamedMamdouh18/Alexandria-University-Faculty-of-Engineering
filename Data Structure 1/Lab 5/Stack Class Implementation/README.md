Create a stack class that implements MyStack interface.

Input Format

The first line contains a comma-sepatared list of the stack elements. Next line contains "push", "pop", "peek", "isEmpty", or "size" depending on the required operation. The last line exists only for the "push" case, which contains the element to push to the stack.

Constraints

The stack contains only integer values.

Output Format

push: prints the stack after the push operation.

pop: prints the stack after the pop operation.

peek: prints the top element of the stack.

isEmpty: prints "True" or "False".

size: prints the size of the stack.

If any error occurs, print "Error"

Sample Input 0

[7, -2, -22, -27, 22, -24, -8, 22, -5, 27, -5, 1, 18, 17, 10, 19]

push

1

Sample Output 0

[1, 7, -2, -22, -27, 22, -24, -8, 22, -5, 27, -5, 1, 18, 17, 10, 19]

Sample Input 1

[-5, -23, 4, 19, 12, 11, 22, -18, -27]

pop

Sample Output 1

[-23, 4, 19, 12, 11, 22, -18, -27]

Sample Input 2

[-3, -12, -3, 15, -7, 9]

peek

Sample Output 2

-3

Sample Input 3

[-12, 1, -23]

isEmpty

Sample Output 3

False

Sample Input 4

[-11, -27, 29]

size

Sample Output 4

3
