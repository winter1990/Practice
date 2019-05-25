package practice.leetcode.hard;

/**
 * @array
 *
 * Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks"
 * (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * What is the most number of chunks we could have made?
 *
 * problems to solve:
 * 1. the condition that a new chunk is formed
 * 2. maximum chunks
 * 3. handle the duplicates
 *
 * [2 1 0 2 4 3 5 4 4 4 7], Output: 3
 *  2 2 2 2 4 4 5 5 5 5 7 max
 *  0 0 0 2 3 3 4 4 4 4 7 min
 *         |           |  division
 *
 * to form a new chunk, we need to make sure that:
 *   all the values in this chunk are smaller than the elements on the right
 *   scan from left to right and track the max value
 *   scan from right to left to track the smallest value
 *
 */
public class MaxChunksToMakeSorted_II {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] max = new int[n];
        max[0] = arr[0];
        for (int i = 1; i < n; i++) max[i] = Math.max(arr[i], max[i - 1]);

        int[] min = new int[n];
        min[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(min[i + 1], arr[i]);

        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted_II m = new MaxChunksToMakeSorted_II();
        System.out.println(m.maxChunksToSorted(new int[]{5,4,3,2,1}));
    }
}
