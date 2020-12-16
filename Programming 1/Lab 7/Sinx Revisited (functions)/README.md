The sine of x can be calculated approximately by summing the first n terms of the infinite series: The taylor series

 (x in radians)

Write a program that will read in a value for x (in degrees) and then calculate its sine. Sum the first n terms, where n represents a positive integer that is read along with the value of x. For factorial use double or long long. You are required to solve the sin(x) problem with the following restrictions:

Write a function that takes the angle in degrees and converts it to radian.
Write a function that takes an input n. Calculates and returns its factorial (n!).
Write your own power function: double power(double n, int m), that takes two arguments n, m. Calculates  and returns as double.
Write a function that takes in an angle in degrees and computes its sine, using the above formula. Your function should call the above three functions.
Input Format

a single line containing x and n

Constraints

double x, 0 ≤ x ≤ 360
integer n, 0 ≤ n ≤ 9

Output Format

"calculated a expected b"
where a is calculated with the above formula and b is calculated with sin in math.h.
print 10 digits to right of dicimal point.

Sample Input 0

30 7
Sample Output 0

calculated 0.5000000000 expected 0.5000000000
Sample Input 1

134.35452463567 7
Sample Output 1

calculated 0.7150280408 expected 0.7150277737
Sample Input 2

254.69224555189226 1
Sample Output 2

calculated 4.4452182642 expected -0.9645216969
