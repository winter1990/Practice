package practice.interview.google;

import java.util.*;

public class UnivalueTree {
    public boolean isUnivalue(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (set.contains(cur.val)) {
                return false;
            }
            set.add(cur.val);
            for (TreeNode node : cur.neightbors) {
                q.offer(node);
            }
        }
        return true;
    }
}

class TreeNode {
    int val;
    List<TreeNode> neightbors;
    public TreeNode(int val) {
        this.val = val;
        neightbors = new ArrayList<>();
    }
}

