Notes:
• Assume that the input arrays will consist of duplicates, you have to eliminate them.
• Your program should read the input arrays from the user.
• You can assume that the input arrays will have a size ≤ 20.
• You should have 4 variables to hold your output:

Array1
Array2
Union Array
Intersection Array
Input Format

a single integer n1, donating the number of elements in Array1
a list of value in the Array1
a single integer n2, donating the number of elements in Array2
a list of value in the Array2

Constraints

Elements of the array can be any integer from the rang -231 to 231-1
1 ≤ n1 ≤ 20
1 ≤ n2 ≤ 20
Array1 can have duplicates elements
Array2 can have duplicates elements
Union array maximum size is 40
Intersection array maximum size is 20
Elements order: You should start with Array1 elements first then Array2 elements

Output Format

Array1: (Distinct elements of Array1)

Array2: (Distinct elements of Array2)

Union: (Union Elements)

Intersection: (Intersection Elements)

Sample Input

8

12 32 14 35 89 16 120 14

9

9 9 12 8 17 120 35 12 36

Sample Output

Array1: 12, 32, 14, 35, 89, 16, 120

Array2: 9, 12, 8, 17, 120, 35, 36

Union: 12, 32, 14, 35, 89, 16, 120, 9, 8, 17, 36

Intersection: 12, 35, 120

Explanation

You should eliminate the duplicates elements from both Array1 and Array2

You should compute the union and intersection

You should print the Array1 and Array2 without duplicates

You should print the resultant Union and Intersection arrays
