/*
A non-empty zero-indexed array A consisting of N integers is given. The 
consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 
0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling 
to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A of N integers, returns the number 
of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 
1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following 
values: 0, 1.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not 
counting the storage required for input arguments).
Elements of input arrays can be modified.
Copyright 2009–2016 by Codility Limited. 
All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package passingcars;

public class PassingCars {

    /*You need to count number of cars passings. Cars are positioned on the road as 
input says and start driving into either one of directions. When car drives,
we can easily see that it will drive by cars moving in the opposite 
direction, but only if they were in front of it. Essentially
that can be formulated as:

Imagine array 0..N
Take element X (iterate from 0 to Nth element)
If value of element X is 0 then count how many 1 elements it has on the right
If value of element X is 1 then count how many 0 elements it has on left
Repeat for next X
Sum up and divide by 2 (cos it takes 2 cars to pass each other), that's the answer.
In case with 0 1 0 1 1 we have 3+1+2+2+2 = 10. Divide by 2 = 5 passings.

We don't count pair 2-1 because 2nd car is driving to the East and never passes 
        the 1st car that is driving away from it to the West.
     */

    public static void main(String[] args) {

        int A[] = {0, 1, 0, 1, 1};

        int countOfZeros = 0, count = 0;

        for (int i = 0; i < A.length; i++) {
            //3 ifs to be evaluated for all elements
            if (A[i] == 0) {
                countOfZeros++;
            }
            if (A[i] == 1) {
                //this statement adds to count the countOfZeros variable every time an element is equal to 1
                count += countOfZeros;
            }
            if (count > 1000000000) {
                System.out.println(-1);
            }
        }
        System.out.println(count);
    }
}
