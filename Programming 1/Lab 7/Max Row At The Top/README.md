Given a two-dimensional array of size n x m, reorder the rows such that the row with the highest row sum is the first row. You should search for the row with the maximum sum and swap it with the first row. If two lines have the same maximum sum then swap that has lower index.

Input Format

first line contains two integers n and m, number of rows and columns.
next n lines each of them contians m integer.

Constraints

1 ≤ n, m ≤ 1000
-1000 ≤ matrix[i][j] ≤ 1000

Output Format

the matrix after swapping the row with the maximum sum with the first row.
n lines each of them contains m integer.

Sample Input

3 4
1 3 5 1
2 50 9 9
2 2 3 4
Sample Output

2 50 9 9
1 3 5 1
2 2 3 4
Explanation

the row with maximum sum is [2, 50, 9, 9] and it's swapped with the first row [1, 3, 5, 1]
