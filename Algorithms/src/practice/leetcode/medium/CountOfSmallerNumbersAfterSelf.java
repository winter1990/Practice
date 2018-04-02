package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
[5, 4, 2, 6, 1] => [3, 2, 1, 1, 0]
 */

/**
 * if want to optimize the time
 * build some data structure to store the numbers
 * duplicate numbers? need to store frequency
 *        1 (0,1)
 *          6 (
 *        2
 *         4
 *          5
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(res);
        }
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = insertNode(root, nums[i]);
        }
        return Arrays.asList(res);
    }

    private Integer insertNode(Node node, int num) {
        int total = 0;
        // if node already exists, just need to update the count of node
        // so only need to consider the cases node.val!=num
        System.out.println(node.val);
        while (node.val != num) {
            // we are scanning from right to left
            // so if smaller, update the left count
            if (num < node.val) {
                if (node.left == null) {
                    node.left = new Node(num);
                }
                node.leftCount++;
                node = node.left;
            } else {
                total += (node.leftCount + node.count);
                if (node.right == null) {
                    node.right = new Node(num);
                }
                node = node.right;
            }
        }
        node.count++;
        return total + node.leftCount;
    }

    class Node {
        Node left;
        Node right;
        int val;
        int count;
        int leftCount;
        public Node(int val) {
            this.val = val;
            count = 0;
        }
    }
}
