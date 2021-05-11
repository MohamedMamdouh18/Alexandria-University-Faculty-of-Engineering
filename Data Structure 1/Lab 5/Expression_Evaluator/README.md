You are required to write a program that takes a symbolic infix expression as input, converts it to postfix notation, evaluates the postfix expression and outputs both; the resulting postfix expression and *its value. *

Note: You should use the stack implementation you did in the last part for any stack data structure needed in the program.

Input Format

First line has Infix expression.

The next 3 lines have the values for "a", "b", and "c", even if not all of them exist in the equation.

Constraints

All operands are integer values.

There are at most 3 variables (a, b, and c) in the expression.

Operators could be any of the following: +, -, *, /, and ^

Expressions can contain parentheses: "(" and ")".

Having 2 consective minuses is possible, where --a = a.

In case of division you should perform an integer division, where "5/2 = 2".

Assume no division by zero will happen.

Output Format

The first line should print the corresponding postfix expression.

The second line should print the integer value of the result.

Incase the expression is invalid, the output will be Error.

Sample Input 0

--a--b

a=1

b=-10

c=9

Sample Output 0

ab+

-9

Sample Input 1

-(a+b)

a=8

b=-2

c=9

Sample Output 1

ab+-

-6

Sample Input 2

--a^b

a=9

b=3

c=3

Sample Output 2

ab^

729

Sample Input 3

a*b*c

a=-2

b=8

c=-3

Sample Output 3

ab*c*

48
