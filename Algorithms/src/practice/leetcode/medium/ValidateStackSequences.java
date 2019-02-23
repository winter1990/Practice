package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @stack
 *
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been
 * the result of a sequence of push and pop operations on an initially empty stack.
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1], Output: true
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2], Output: false -> 1 can not be popped before 2
 *
 * 1 2 3 4 5
 * possible popped sequence
 * 2 3 1 5 4
 * 2 3 5 4 1
 * 4 3 5 2 1
 * 1 3 5 4 2
 * 1 2 4 5 3
 * 1 5 4 3 2
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

}
