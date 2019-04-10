package practice.leetcode.medium;

import java.util.Stack;

/**
 * @array
 *
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
 * [2, 9, 7, 8, 5, 4, 6, 1]
 * start with 0:
 * 0 [2] 2
 * 1 [9] [2 9] 9 2
 * 2 [7] [7 9] [7 9 2] 7 7 2
 * 3 [8] [8 7] [8 7 9] [8 7 9 2] 8 7 7 2
 *
 * [2, 9, 7, 8, 5, 4, 6, 1]
 * for each element, we search the elements before it and find the smaller one
 *   for 7 at index 2
 *     the smaller element before it is 2 at 0, distance is 2
 *     the smaller element after it is 5 at 4, distance is 2
 *     number of subarrays with minimum value 7: 2 * 2 = 4
 *     total value that contribute to sum is: 7 * 4
 * ans = sum(A[ii] * left[i] * right[i])
 * for rightmost element 1 or any smallest element in the middle, the left distance is (i+1)
 * for smallest element in the middle or left most, the right distance is (length-i)
 * need two arrays:
 * left[i] the distance between A[i] and previous smaller value
 * right[i] the distance between A[i] and next smaller value
 */
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int n = A.length, m = (int) Math.pow(10, 9) + 7;
        int[] l = new int[n], r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = i + 1;
            r[i] = n - i;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            l[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                r[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) res = (res + (A[i] * l[i] * r[i]) % m) % m;

        return res;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums s = new SumOfSubarrayMinimums();
        int[] in = {2, 9, 7, 8, 5, 4, 6, 1};
        System.out.println(s.sumSubarrayMins(in));
    }
}
