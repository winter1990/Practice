package practice.leetcode.medium;

/**
 * Given an input array where num[i] ≠ num[i+1]
 * O(logn) solution
 *
 * binary search:
 * get mid. meaningless to comapre st/end
 * compare with adjacent
 * if mid>mid+1,e=mid
 *    mid<mid+1,s=mid+1
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
