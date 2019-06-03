package practice.leetcode.medium;

/**
 * @array
 *
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of
 * set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S
 * should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs
 * in S.
 *
 * Index       0 1 2 3 4 5 6
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation: A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * use an array with size n to track the length of the longest
 * and also to avoid re-traversing the array
 *
 * for an element in array a[i], the value can be in two cases:
 *   a[i] = i, it will stop at index i
 *   a[i] != i, it will visit another index and value to continue
 *   because a[i] is unique in the array, so each number will only be visited ONCE - use boolean array
 *
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) max = Math.max(max, countLoop(nums, i, isVisited));
        }
        return max;
    }

    private int countLoop(int[] a, int i, boolean[] isVisited) {
        int count = 0;
        while (!isVisited[i]) {
            isVisited[i] = true;
            count++;
            i = a[i];
        }
        return count;
    }
}
