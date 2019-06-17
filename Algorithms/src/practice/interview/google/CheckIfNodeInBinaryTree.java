package practice.interview.google;

/**
 * tree node 定义是 class Node { Node left, right }; 不需要value. 然后每个node隐含一个 id
 *        n             1
 *      /   \
 *     n     n       2    3
 *    / \     \
 *   n  n      n   4  5     7
 *       \
 *        n            11
 * 没有val,但是有默认id
 * 1 2 3 4 5 7
 * 给6,返回false因为没有在tree里面
 *
 * if complete tree, total nodes 2^n-1
 *
 */

public class CheckIfNodeInBinaryTree {
    public boolean isInTheTree(Node root, int target) {
        if (root == null) return false;
        int level = 1;
        while (target > Math.pow(2, level) - 1) level++;
        Node cur = root;
        int start = (int) Math.pow(2, level - 1);
        int count = (int) Math.pow(2, level - 1);
        while (cur != null && count != 1) {
            if (target < start + count / 2) {
                cur = cur.left;
            } else {
                cur = cur.right;
                start += count / 2;
            }
            count /= 2;
        }
        return cur != null;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n10 = new Node();
        Node n11 = new Node();
        Node n12 = new Node();
        Node n24 = new Node();
        Node n25 = new Node();
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.left = n6;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n12.left = n24;
        n12.right = n25;

        CheckIfNodeInBinaryTree c= new CheckIfNodeInBinaryTree();
        System.out.println(c.isInTheTree(n1, 13));
    }

    static class Node {
        Node left, right;
    }
}
