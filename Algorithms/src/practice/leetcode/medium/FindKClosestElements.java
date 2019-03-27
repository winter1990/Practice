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
 * intuition:
 * find the element and expand to left and right
 *
 * optimization:
 * array is sorted -> binary search
 * we are looking for k elements -> the range should be A[i] ~ A[i + k -1].
 * search for i
 * we need x to be the center of the elements
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
}
