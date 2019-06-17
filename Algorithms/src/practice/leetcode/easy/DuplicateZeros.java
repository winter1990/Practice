package practice.leetcode.easy;

/**
 * @array
 *
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to
 * the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 * Example 1:
 * Input: [1,0,2,3,0,4,5,0]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        // 0 1 0 2 3 5 0 0
        // 0 0 1 0 0 2 3 5 0 0 0 0
        if (arr == null || arr.length <= 1) return;
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) count++;
        }
        int len = n + count;
        for (int i = n - 1, j = len - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < n) arr[j] = arr[i];
            } else {
                if (j < n) arr[j] = 0;
                --j;
                if (j < n) arr[j] = 0;
            }
        }
    }
}
