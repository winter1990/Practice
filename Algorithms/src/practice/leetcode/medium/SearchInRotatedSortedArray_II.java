package practice.leetcode.medium;

/**
 * duplicates are allowed
 * if no duplicate, can use binary search
 * if a[s]=a[e], do not know which half to go
 * but if a[s]!=a[e]
 *
 * 1233334 3341233 no
 *         4123333
 */
public class SearchInRotatedSortedArray_II {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) return true;
            if (nums[s] == nums[e]) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == target) return true;
                }
                return false;
            } else {
                if (nums[s] <= nums[mid]) {
                    if (target >= nums[s] && target < nums[mid]) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[e]) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
