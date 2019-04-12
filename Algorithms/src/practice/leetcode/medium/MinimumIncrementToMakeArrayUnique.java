package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 *
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * Return the least number of moves to make every value in A unique.
 * Input: [1,2,2] Output: 1
 * Input: [3,2,1,2,1,7] Output: 6
 * 0 <= A[i] < 40000
 *
 * sort the array
 * 1 1 2 2 3 5 7
 * start with second element:
 *   use a counter to track which number we need to compare with
 *   count = 1
 *   if a[i] = a[i - count], res += count++
 *   if a[i] - a[i - count] < count, res += count - (a[i] - a[i - count])
 *   else count = 1
 */
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length < 2) return 0;
        Arrays.sort(A);
        int count = 1, res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - count] == A[i]) {
                res += count++;
            } else if (A[i] - A[i - count] < count) {
                res += A[i - count] + count - A[i];
                count++;
            } else {
                count = 1;
            }
        }
        return res;
    }

    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        int count = 0, need = 0;
        for (int a : A) {
            count += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique m = new MinimumIncrementToMakeArrayUnique();
        int[] in = {3,2,1,2,1,1};

        System.out.println(m.minIncrementForUnique(in));
    }
}
