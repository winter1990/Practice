package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 * @quickselect
 */
public class MinimumMovesToEqualArrayElements_II {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            res += (nums[j] - nums[i]);
            i++;
            j--;
        }
        return res;
    }

    // if we increase or decrease the numbers to median, we can get the optimal solution/moves
    // the median can be found using quick select
    public int minMoves21(int[] A) {
        int sum = 0;
        int median = quickselect(A, A.length / 2 + 1, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            sum += Math.abs(A[i] - median);
        }
        return sum;
    }

    public int quickselect(int[] A, int k, int start, int end) {
        int l = start;
        int r = end;
        int pivot = A[(l + r) / 2];
        while (l <= r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;
            if (l >= r) break;
            swap(A, l++, r--);
        }
        if (l - start + 1 > k) return quickselect(A, k, start, l - 1);
        if (l - start + 1 == k && l == r) return A[l];
        return quickselect(A, k - r + start - 1, r + 1, end);
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements_II getmin = new MinimumMovesToEqualArrayElements_II();
        int[] in = {1, 0, 0, 8, 6}; // n=5 15/5=3
        System.out.println(getmin.minMoves2(in));
    }
}
