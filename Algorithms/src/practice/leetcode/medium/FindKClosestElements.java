package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @binarysearch
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order.
 * If there is a tie, the smaller elements are always preferred.
 *
 * brute force
 * linear search
 *   two pointers l = 0 , r = n - 1
 *   narrow down the window size
 *   compare the difference with x, move the larger one
 *
 * [0 2 3 5 8 12 15]
 * k = 4, x = 3, [0 2 3 5]
 * k = 3, x = 0, [0 2 3]
 * search the left bound
 *
 * optimization:
 * because array is sorted -> binary search
 * we are looking for k elements -> the range should be A[i, i + k -1].
 * our target becomes searching for i
 * we need x to be the center of the sub array, with window size k
 * compare the distance between x - A[mid] and A[mid - k] - x
 * If x - A[mid] > A[mid + k] - x,
 * it means A[mid + 1] ~ A[mid + k] is better than A[mid] ~ A[mid + k - 1],
 * and we have mid smaller than the right i.
 * So assign left = mid + 1.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(arr[left + i]);
        return res;
    }

    // intuitive and linear solution
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {
            if (arr[r] - x >= x - arr[l]) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) res.add(arr[i]);
        return res;
    }
}
