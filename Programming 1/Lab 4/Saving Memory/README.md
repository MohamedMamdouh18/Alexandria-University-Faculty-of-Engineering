Given two numbers 0 ≤ x, y ≤ 15 you are required to store them in the most efficient way. x and y need only 4 bits so using int(32 bit), short(16 bit), char(8 bit) will be a wast of memory. It may sound that the wast is small but when you have to store 10^6 such variable then you will start to worry about memory usage. The trick is to use char to save x and y. So you should store x in higher 4 bits and y in lower 4 bits of char. Scan x and y as integers and check that 0 ≤ x, y ≤ 15. Compress x and y in char z and print z as integer.

Input Format

Two integers x, y

Constraints

x, y are integers.

Output Format

print char z as integer.
if x or y is not in range[0, 15] print "Error"

Sample Input

7 3
Sample Output

115
Explanation

x = 7, in binary x = 0111
y = 3, in binary y = 0011
z = 115, in binary 01110011 which is x put in 4 most significant bits and y on lower 4 bits.

Submissions: 94
Max Score: 100
Difficulty: Easy
Rate This Challenge:

    
More
