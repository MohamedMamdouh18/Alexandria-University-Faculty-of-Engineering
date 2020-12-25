It should find ALL occurrences of the word in the input line. Your program should print the beginning index of each occurrence and it should print the total number of occurrences.

Input Format

A string line (use gets() function to read a whole line).

A string word.

Hint: fgets is more secure that gets

Constraints

Max length is 256.

The input string will contain only spaces and a-z.

The word string will contain only a-z.

You should think about special cases and handle them. Your program must NOT crash under any input.

Output Format

Write:

Occurrence at index i

each time you found the word, where i is the index of the first character of the target word

Sample Input 0

aabacd aabaaba aabcaaba

aaba

Sample Output 0

Occurrence at index 0

Occurrence at index 7

Occurrence at index 10

Occurrence at index 19

Total number of occurrences = 4

Sample Input 1

abacadaeafag
a
Sample Output 1

Occurrence at index 0

Occurrence at index 2

Occurrence at index 4

Occurrence at index 6

Occurrence at index 8

Occurrence at index 10

Total number of occurrences = 6
