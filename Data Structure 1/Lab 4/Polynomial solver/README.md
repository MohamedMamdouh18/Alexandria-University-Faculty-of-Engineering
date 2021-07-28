You are required to design a linked allocation system to represent and manipulate polynomials. You should use one of the linked list classes you implemented in the last part. Each term of the polynomial will be represented as a node, using its coefficient and exponent. Assume that you have 3 available polynomial variables: A, B and C, which can be set by the user and one variable R that acts as an accumulator for the results of operations on other polynomials. You should order the polynomial terms in descending order by the exponent. A polynomial can have a negative exponent. Create a user-friendly, menu-driven system that performs the following operations:

Read in a polynomial and store it in variable A, B, or C.
Output a polynomial using a form that clearly displays it.
Add two polynomials and store the result in R.
Subtract two polynomials and store the result in R.
Multiply two polynomials and store the result in R.
Evaluate a polynomial at some point, a, where a is a floating point constant. In other words, substitute by the given value in your polynomial. Display the result as a floating point.
Clear a polynomial. Note that: a polynomial whose value is cleared or initially unset cannot be involved in an operation. It is required to implement the following interface by the core of your application. The core of the application should throw a runtime exception when it encounters any invalid input or operation.
Input Format

set:set the values of coeffecients for a polynomial (exponents should be in desending order) given the name of polynomial (A,B,C) and the coeffecients as a linked list.
print: prints a polynomial in a readble format given its name.
add: adds two polynomials given their names.
sub: subtracts the first polynomial from he second given their names.
mult: multiplies two polynomials given their names.
clear: clears a polynomial given its name.
eval: evaluates a polynomial given its name. You should print "Error" in case you catch any exceptions (empty polynomial,ivalid operation,etc....)
Constraints

_

Output Format

_

Sample Input 0

set
A
[1,-3,2]
print
A
set
B
[1,-5,6]
print
B
set
C
[1,-9,26,-24]
print
C
Sample Output 0

x^2-3x+2
x^2-5x+6
x^3-9x^2+26x-24
Sample Input 1

set
A
[1,-9,26,-24]
set
B
[5,10,4,30]
add
A
B
Sample Output 1

6x^3+x^2+30x+6
Sample Input 2

set
A
[1,-13,50,-56]
eval
A
5
Sample Output 2

-6
Sample Input 3

set
A
[1,-13,50,-56]
clear
A
Sample Output 3

[]
Sample Input 4

set
A
[20,46,-30,-78]
set
B
[5,41,-50,0]
sub
A
B
Sample Output 4

15x^3+5x^2+20x-78
Sample Input 5

set
A
[32,41,67]
set
B
[2,3,1]
mult
A
B
Sample Output 5

64x^4+178x^3+289x^2+242x+67
