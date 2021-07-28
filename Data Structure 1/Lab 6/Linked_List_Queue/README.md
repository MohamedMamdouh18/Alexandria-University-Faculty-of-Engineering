Create a Class LinkedListQueue that implements IQueue assuming the queue elements are all integers

Input Format

The input consists of the following lines:

Line 1: A comma-separated list of the initial queue elements
Line 2: The required operation; enqueue, dequeue, isEmpty, or size.
Line 3: exists only in the enqueue case; contains the value to enqueue.
Constraints

Queue elements are always integers

Output Format

In the enqueue and dequeue cases, the ouput is a comma-separated list of the queue elements.
For isEmpty, the output is either "True" **or "False"**.
For size, the output is the queue size.
Sample Input 0

[-3, -22, -16, 8, -23]
enqueue
-12
Sample Output 0

[-12, -3, -22, -16, 8, -23]
Sample Input 1

[-20, -2, -17]
dequeue
Sample Output 1

[-20, -2]
Sample Input 2

[-6, -30, -5]
isEmpty
Sample Output 2

False
Sample Input 3

[18, -11, -8, 10, 0, 14, -21, 9]
size
Sample Output 3

8
