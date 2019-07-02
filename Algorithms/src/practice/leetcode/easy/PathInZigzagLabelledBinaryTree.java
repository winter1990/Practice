package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @tree
 *
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even
 * numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with
 * that label.
 *
 * for each level in the tree
 * level start with 0
 * the range of values is [2^level, 2^(level+1)-1]
 */
public class PathInZigzagLabelledBinaryTree {
    public static List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list = new LinkedList<>();
        int cur = label;
        list.addFirst(cur);
        while (cur != 1) {
            int level = (int) (Math.log(cur) / Math.log(2));
            int offset = (int) Math.pow(2, level + 1) - 1 - cur;
            cur = ((int) Math.pow(2, level) + offset) / 2;
            list.addFirst(cur);
        }
        return list;
    }

    // this is only applicable with non zigzag tree
    public static List<Integer> pathInZigZagTree1(int label) {
        int level = 0;
        while (label > (1 << level) - 1) level++;
        List<Integer> res = new LinkedList<>();
        int cur = 1; // start from root
        while (res.size() < level) {
            if (label <= cur * 2) {
                res.add(cur);
                cur *= 2;
            } else {
                res.add(cur);
                cur = cur * 2 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(10));
    }
}
