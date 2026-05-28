Bitwise Operators
AND Operator (&)
If both corresponding bits are 1, the resulting bit is 1; otherwise, it is 0.

13: 1101
7: 0111
&  : 0101 → 5
OR Operator (|)
If either corresponding bit is 1, the resulting bit is 1.

13: 1101
7: 0111
|  : 1111 → 15
XOR Operator (^)
If bits differ, the result is 1; if the same, result is 0.

13: 1101
7: 0111
^  : 1010 → 10
NOT Operator (~)
Flips all bits of the number.

5: 0000 0101
~5: 1111 1010 → -6 (in two's complement)
Shift Operators
Right Shift (>>): Shifts bits to the right, fills left with 0s.

13 >> 1 = 0110 → 6
Left Shift (<<): Shifts bits to the left, fills right with 0s.

13 << 1 = 11010 → 26
Bit Manipulation Tricks and Techniques
1. Swapping Two Numbers Without a Third Variable
   A = A ^ B
   B = A ^ B
   A = A ^ B
2. Checking if the i-th Bit is Set
   (1 << i) & num   → set if result ≠ 0
   (num >> i) & 1   → set if result ≠ 0
3. Setting the i-th Bit
   num | (1 << i)
4. Clearing the i-th Bit
   num & ~(1 << i)
5. Toggling the i-th Bit
   num ^ (1 << i)