package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @array
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * method 1
 * brute force: two pointers i [0,n-2] j [i+1,n-1]
 *
 * method 2
 * sort and compare: Arrays.sort(), start from index 1 to n-1, compare with previous value
 *
 * method 3
 * set: put visited value in the set, and set.add() false then we find duplicate
 */
public class ContainsDuplicate {
    public  boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] in = {1,3,2,4,5,1,7};
        ContainsDuplicate c = new ContainsDuplicate();
        System.out.println(c.containsDuplicate3(in));
    }
}
