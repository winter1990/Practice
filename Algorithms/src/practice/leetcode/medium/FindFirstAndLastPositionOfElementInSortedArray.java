package practice.leetcode.medium;

/**
 * @binarysearch
 *
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = findLeftBound(nums, target);
        res[1] = findRightBound(nums, target);
        return res;
    }

    private int findRightBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                if (mid != nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    private int findLeftBound(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                if (mid != 0 && nums[mid] == nums[mid - 1]) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
