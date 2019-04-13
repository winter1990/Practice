package practice.leetcode.easy;

import java.util.*;

/*
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

/**
 * two sum thinking:
 * the path from any node (in the middle) to current = the sum from root node - sum of root to middle node
 * also need to know how many paths equal to target
 * base condition: path from middle to current = target
 * map stores all the possible sum in the path to current node
 * if sum-target exists in the map, there must be a sub-path that the sum equals to target
 * multiple paths exists, so map also needs to record the frequency
 * res=total paths ENDED at the node
 */
public class PathSum_III {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPath(root, 0, sum, map);
    }

    private int findPath(TreeNode node, int sum, int target, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        int pathsToCurrentNode = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0 ) + 1);
        int res = pathsToCurrentNode + findPath(node.left, sum, target, map) + findPath(node.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
