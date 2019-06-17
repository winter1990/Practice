package practice.leetcode.easy;

/**
 * @tree
 *
 * Each node has another two boolean attributes :
 * isLeaf and val. isLeaf is true if and only if the node is a leaf node.
 * The val attribute for a leaf node contains the value of the region it represents.
 *
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 *
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 *
 * for each node in a quad tree, it is represented as (isLeaf, value)
 * only if all the values in the area is the same, then it is a leaf node -> isLeaf = true
 * for the value, if all the values are 1, then true, if all 0s, then false
 */
public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] g, int x, int y, int n) {
        if (n == 1) {
            return new Node(g[x][y] == 1, true, null, null, null, null);
        }
        Node tl = construct(g, x, y, n / 2);
        Node tr = construct(g, x, y + n / 2, n / 2);
        Node bl = construct(g, x + n / 2, y, n / 2);
        Node br = construct(g, x + n / 2, y + n / 2, n / 2);
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            if (tl.val && tr.val && bl.val && br.val) {
                return new Node(true, true, null, null, null, null);
            }
            if (!tl.val && !tr.val && !bl.val && !br.val) {
                return new Node(false, true, null, null, null, null);
            }
        }
        return new Node(false, false, tl, tr, bl, br);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
