package practice.leetcode.medium;

/**
 * @array
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number
 * of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 *
 * Input: arr = [4,3,2,1,0], Output: 1, [4,3,2,1,0]
 * Input: arr = [1,0,2,3,4], Output: 4, [0,1] [2] [3] [4]
 *
 * [2 0 1 4 3] => 2 [2 0 1][4 3]
 *
 * problems to solve:
 * 1. the element a[i] should be at the position i
 * 2. divide the array into maximum chunks
 *
 * if element a[i]=i, then itself can be a single chunk
 * if a[i] > i, the right bound must be a[i]
 *
 * keep track of the right bound of the window
 *   if r >= i, r = max(r, a[i])
 *   else max=a[i] res++
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return 1;
        int n = arr.length, res = 1, max = arr[0];
        for (int i = 1; i < n; i++) {
            if (i <= max) {
                max = Math.max(max, arr[i]);
            } else {
                max = arr[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {2,0,1,4,3};
                // {1,0,2,3,4};
                // {4,3,2,1,0};
                // {0,1,2,3};
                // {0,4,2,3,1};
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        System.out.println(m.maxChunksToSorted(in));
    }
}
