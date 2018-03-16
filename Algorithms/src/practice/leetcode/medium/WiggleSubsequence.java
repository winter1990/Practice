package practice.leetcode.medium;

/*
Input: [1,7,4,9,2,5]               Output: 6
Input: [1,17,5,10,13,15,10,5,16,8] Output: 7, There are several, One is [1,17,10,13,10,16,8].
Input: [1,2,3,4,5,6,7,8,9]         Output: 2
 */

import java.util.Stack;

/**
 * need to back track the previous numbers, so use stack
 * second element can be larger or smaller, need a flag to check odd/even element in the stack
 * 1 10 5 15 20 17, when increasing/decreasing, check peek(), always store the max and min
 *
 * flag even if true, even number in stack is bigger than last number
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return 1;
        }
        boolean even = nums[i] > nums[0];
        stack.push(nums[i]);
        i += 1;
        for (; i < nums.length; i++) {
            if (even) { // even index bigger
                if (stack.size() % 2 == 0) { // push smaller or update larger
                    pushSmallerOrUpdateLarger(stack, nums[i]);
                } else { // push larger or update smaller
                    pushLargerOrUpdateSmaller(stack, nums[i]);
                }
            } else { // odd index bigger
                if (stack.size() % 2 == 0) { // push larger or update smaller
                    pushLargerOrUpdateSmaller(stack, nums[i]);
                } else {
                    pushSmallerOrUpdateLarger(stack, nums[i]);
                }
            }
        }
        return stack.size();
    }

    private void pushLargerOrUpdateSmaller(Stack<Integer> stack, int n) {
        if (n > stack.peek()) {
            stack.push(n);
        } else if (n < stack.peek()) {
            stack.pop();
            stack.push(n);
        }
    }

    private void pushSmallerOrUpdateLarger(Stack<Integer> stack, int n) {
        if (n < stack.peek()) {
            stack.push(n);
        } else if (n > stack.peek()) {
            stack.pop();
            stack.push(n);
        }
    }


    public static void main(String[] args) {
        int[] in = {1,5,2,2,2,1,3};
        /*
        0,0             1
        3,3,3,2,5,3,4   5
        1,2,3,4,5,6,7   2
        1,7,4,9,2,5     6
        1,17,5,10,13,15,10,5,16,8   7
        1,5,2,2,2,4,3   5
        1,5,2,2,2,1,3   4
         */
        WiggleSubsequence w = new WiggleSubsequence();
        System.out.println(w.wiggleMaxLength(in));
    }
}
