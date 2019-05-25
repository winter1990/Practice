package practice.leetcode.easy;

/**
 * @array
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * two pointers:
 * i = 0, j = 0
 * if (a[j] != target) a[i++] = a[j++]
 */
public class RemoveElement {
    public int removeElement2(int[] nums, int val) {
        int n = nums.length, i = 0, j = 0;
        while (j < n) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    /**
     * another im-place method:
     * [1 0 2 1 3 4 1] target = 1
     * i = 0, j = len
     * if (a[i] = target) a[i] = a[j-1], j--
     * else i++
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
