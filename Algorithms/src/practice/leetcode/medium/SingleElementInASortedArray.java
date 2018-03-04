package practice.leetcode.medium;

/** 0 1 2 3 4 5 6 7 8
 * [1,1,2,3,3,4,4,8,8]->2
 * [1,1,2,2,3,3,4,5,5]->4
 * linear search is easy
 *
 * binary search?
 * 01 23 45
 * get mid and check if even or odd
 * if even check right
 * if odd check left
 * if same then on right half
 *
 * number of element must be odd
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    s = mid + 2;
                } else {
                    e = mid - 2;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return nums[s];
    }

    /**
     * find the first even-index number not followed by the same number
     *
     */
    public int singleNonDuplicate1(int[] nums) {
        int n = nums.length;
        int lo=0, hi = n / 2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) hi = m;
            else lo = m + 1;
        }
        return nums[2 * lo];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray se = new SingleElementInASortedArray();
        int[] in = new int[]{2};
        System.out.println(se.singleNonDuplicate(in));
    }
}
