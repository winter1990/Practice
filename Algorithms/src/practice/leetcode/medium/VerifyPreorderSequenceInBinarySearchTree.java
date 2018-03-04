package practice.leetcode.medium;

import java.util.Stack;

/*
               4
             /  \
           2     5
          / \     \
         1   3     6
pre-order: 4 2 1 3 5 6
correct    4 3 1 2 5 6
next value is left or right child
all left smaller
all right larger
check current and next element
linear search
 */

public class VerifyPreorderSequenceInBinarySearchTree {
    /**
     * instead of scanning, use some DS to keep track
     * if in-order, its increasing
     * push cur to stack,
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack1 = new Stack<>(); // traverse down the tree, value should be decreasing
        Stack<Integer> stack2 = new Stack<>(); // this stack is to track the inorder
        for (int val : preorder) {
            if (!stack2.isEmpty() && val < stack2.peek()) {
                return false;
            }
            while (!stack1.isEmpty() && val > stack1.peek()) {
                stack2.push(stack1.pop());
            }
            stack1.push(val);
        }
        return true;
    }

    // time O(n^n)
    public boolean verifyPreorder1(int[] preorder) {
        if (preorder == null || preorder.length <= 2) {
            return true;
        }
        int len = preorder.length;
        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            while (j < len && preorder[j] < preorder[i]) {
                j++;
            }
            while (j < len && preorder[j] > preorder[i]) {
                j++;
            }
            if (j != len) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] in = {1,2,3};
        VerifyPreorderSequenceInBinarySearchTree vp = new VerifyPreorderSequenceInBinarySearchTree();
        System.out.println(vp.verifyPreorder(in));
    }
}
