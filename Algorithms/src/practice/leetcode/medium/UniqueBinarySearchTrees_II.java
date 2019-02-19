package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @dp
 * @tree
 * @recursion
 *
 * how to build the tree?
 * start with root, we can select between [1, n]
 * if we select 1, all rest of nodes are on right subtree
 * so we have another sub-set of numbers from [2, n]
 * recursively build the left and right subtree and pass the values can be selected
 * if n = 5 and we select 3, so [1,2] and [4,5] are for next recursive call respectively, start and end
 * base condition:
 * start = end? leaf node, we can still continue
 * start > end? return empty list
 * for i in [1:n], get left tree list and right tree list, i is the root (new), add left and right to root node
 * add node i to list
 */
public class UniqueBinarySearchTrees_II {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        List<TreeNode> list = new LinkedList<>();
//        System.out.println(list);
//        list.add(null);
//        list.add(null);
//        System.out.println(list);
        UniqueBinarySearchTrees_II uni = new UniqueBinarySearchTrees_II();
        System.out.println(uni.generateTrees(0));
    }
}
