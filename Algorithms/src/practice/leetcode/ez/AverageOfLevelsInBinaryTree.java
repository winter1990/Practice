package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        double sum = 0;
        int i = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (i++ < n) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(sum / n);
            i = 0;
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
