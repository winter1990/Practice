package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @tree
 *
 * level order traversal
 * BFS, using a queue
 * sum up all the nodes and divide by size of the level
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        double sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(sum / n);
            sum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        AverageOfLevelsInBinaryTree avg = new AverageOfLevelsInBinaryTree();
        System.out.println(avg.averageOfLevels(n1));
    }
}
