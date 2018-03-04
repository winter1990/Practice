package practice.leetcode.medium;

/**
 * linear -brute force
 *
 * binary search:
 * [1 2 2 3 3 3 4],3->[3 5]
 * if val found, compare with num[i] and num[i-1]
 * helper findL findR
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    private int findRight(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    private int findLeft(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
