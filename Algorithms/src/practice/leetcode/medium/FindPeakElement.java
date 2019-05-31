package practice.leetcode.medium;

/**
 * @array
 * @binarysearch
 *
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * brute force:
 * scan from 0 to n-1, if larger than left and right, then the peak is found
 *
 * binary search:
 * get mid element and compare with adjacent element
 * how can we go one half and eliminate the other half by comparing a[s] a[mid] a[e]?
 * if a[mid] < a[mid+1], there must be a peak in the right half because a[n-1]=-∞, s=mid+1
 * else e = mid because mid might be the peak
 *
 * why comparing a[mid] and a[mid+1] instead of a[mid-1]?
 * because when getting the middle index, we are getting the middle or 1 element left in the array
 * so that we are making sure if there are only 2 elements, i+1 is still not overflow
 * if len = 1, then return s directly
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
