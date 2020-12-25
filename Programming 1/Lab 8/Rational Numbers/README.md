A rational number consists of a numerator and a denominator. You should write a program

that supports the following operations on rational numbers:

1. Addition

2. Subtraction

3. Multiplication

4. Division

In this problem, you're required to take as input two rational numbers, and the required oper-

ation. The output should print the expression being evaluated along with its result.

Notes:

• Each rational number should be in the reduced form (i.e: divide both numerator and

denominator by their greatest common divisor (GCD))

• You are required to write a function for each of the above ve operations.

• You are required to use structures to make a new data type called \Fraction", which

contains 2 integers: numerator and denominator. You can read it with \%d/%d"

• The four functions should have the following prototypes:

{ Fraction add(Fraction num1, Fraction num2);

{ Fraction subtract(Fraction num1, Fraction num2);

{ Fraction multiply(Fraction num1, Fraction num2);

{ Fraction divide(Fraction num1, Fraction num2);
