package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 *
 * iterate num2, store the increasing [1,3][3,4]
 * if decrease, still need to track all the previous numbers, to add another stack
 * [2,1,3]
 */
public class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], - 1);
        }
        return res;
    }
}
