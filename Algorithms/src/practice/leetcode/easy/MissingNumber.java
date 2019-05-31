package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * Given an array containing n distinct numbers from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * method 1
 * sort and scan through the array
 * O(NlogN + N), O(1)
 *
 * method 2
 * elements in range [0,n] and one is missing
 * total sum = 0 + 1 + ... + n
 * get actual sum
 * total - sum
 * O(N), O(1)
 *
 * method 3
 * based on 2, do the binary search
 * O(NlogN + logN), O(1)
 *
 * method 4
 * n = 5, [0 1 2 3 4 5] -> [5 4 1 2 0]
 * bitwise XOR, all the indices and all the elements, use ^ should be 0 if no number is missing
 * so res = len and xor all the element and index will get the result
 * O(N), O(1)
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length, total = 0;
        for (int i = 0; i < n; i++) total += nums[i];
        return (1 + n) * n / 2 - total;
    }

    public int missingNumber1(int[] a) {
        Arrays.sort(a);
        int i = 0;
        while (i < a.length) {
            if (a[i] != i) break;
        }
        return i;
    }

    public int missingNumber2(int[] a) {
        Arrays.sort(a);
        int n = a.length, s = 0, e = n - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (a[mid] > mid) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public int missingNumber3(int[] a) {
        int res = a.length;
        for (int i = 0; i < a.length; i++) {
            res ^= i;
            res ^= a[i];
        }
        return res;
    }

}
