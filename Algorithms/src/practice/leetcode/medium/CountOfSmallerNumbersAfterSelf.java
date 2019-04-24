package practice.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @array
 * @daq
 * @sementtree
 *
 * [5, 4, 2, 6, 1] => [3, 2, 1, 1, 0]
 *
 * use a tree-like data structure and track the visited numbers
 * from right most element: keep track how many elements are smaller than current node
 * [3, 2, 2, 6, 1]
 *        1 (0,1)
 *         \
 *          6 (3,1)
 *         /
 *        2 (0,2)
 *         \
 *          3 (0,1)
 * when traversing to left node, increase the count in the path
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
        while (node.val != num) {
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
