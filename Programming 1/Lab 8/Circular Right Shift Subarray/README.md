Given array A of size n, we say that elements of A[I...J]  form a subarray.

Your task is to perform circular right shift queries on subarrays of A.

A circular right shift can be performed by reversing the array multiple times. If we want to shif subarray A[I...J]  to the right by K places, we can do that by calling a 

function that reverses a subarray. Can you do it in place? :D

You must use the functions difined below in the editor.

Input Format

first line contains :N size of the array

second line contains N integers of the array

third line contains :Q number of queries (shifts to be done on the array)

the next Q lines each of them contains three integers

L: left index of the subarray

R: right index of the subarray

K: the number of elements to shift

Output Format

print the array after performing all the queires

Sample Input 0

5

1 2 3 4 5

2

0 1 1

2 4 10 

Sample Output 0

2 1 5 3 4

Explanation 0

first query (0 1 1) shifts subarray A[0...1] to the right by 1

second query (2 4 10) shifts subarray A[2...4] to the right by 10

