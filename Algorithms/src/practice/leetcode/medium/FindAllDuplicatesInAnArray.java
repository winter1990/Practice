package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 * intuitive solution
 * use a set to store the visited numbers
 * if exists, then add to result set
 * O(N), O(N)
 *
 * optimization
 * make use of the a[i] = [1, n]
 * if we put the element at the index of a[i] - 1, then if the position has been taken, then it is the duplicate
 * [4,3,2,7,8,2,3,1]
 *  7 3 2 4 8 2 3 1
 *  3 3 2 4 8 2 7 1
 *  2 3 3 4 8 2 7 1
 *  3 2 3 4 8 2 7 1 add 3 to result
 *          1 2 7 8
 *  1 2 3 4 3 2 7 8
 * the swap and look up in the result set all take time, which will cause O(N^2) for worst case
 *
 * the key point is, how we can mark the element as 'visited'
 * [2 1 3 2], for 2, we need to mark the index 1 as 'visited'
 * without doing the swap or using extra space, we can only flip it
 * every time we check an element, get abs() and check the target position is positive or negative
 * if negative, it means it was 'visited'
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) res.add(index + 1);
            nums[index] = -nums[index];
        }
        return res;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
                if (nums[i] != i + 1 && nums[nums[i] - 1] == nums[i]) {
                    if (!res.contains(nums[i])) res.add(nums[i]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        System.out.println(f.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
