In this problem, you are required to write a program for a simple calculator that performs only 5 mathematical operations (+, -, /, *, %). Your program should scan 3 inputs:

First number a
Operator (+, −, /, ∗, %) op
Second number b
Your program then should rewrite the expression back on the screen along with its result r. You must check for the following errors:

When the user enters a symbol that does not represent a valid operator (+, −, /, ∗, %), print "ERROR: Unsupported Operator!" .
When the user tries to divide by zero or mod zero print "ERROR: Division by zero is not allowed!" .
Input Format

a op b

Constraints

Two integers a, b
-1000 ≤ a, b ≤ 1000
op can be any character

Output Format

if valid then output:
a op b = r
else output error message as indicated above.

Sample Input

1 + 2

Sample Output

1 + 2 = 3
