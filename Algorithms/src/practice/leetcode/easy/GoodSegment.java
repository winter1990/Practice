package practice.leetcode.easy;

import java.util.Arrays;

/**
 * [1 3 5 10 20 45 46 50], [3 100]
 *
 */
public class GoodSegment {
    public static int goodSegment(int lo, int hi, int[] arr) {
        Arrays.sort(arr);
        int max = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (lo > arr[i] || arr[i] > hi) continue;
            if (lo == arr[i]) {
                lo++;
            } else if (arr[i] > lo) {
                max = Math.max(max, Math.min(hi, arr[i]) - lo + 1);
                lo = arr[i] + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int lo = 3, hi = 48;
        int[] arr = {1,3,5,10,20,45,46,50,100,101};
        System.out.println(goodSegment(lo,hi,arr));
    }
}
