package practice.leetcode.ez;

/**
 * @tree
 *
 * for each node in a quad tree, it is represented as (isLeaf, value)
 * only if all the values in the area is the same, then it is a leaf node -> isLeaf = true
 * for the value, if all the values are 1, then true, if all 0s, then false
 */
public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return constructNode(grid, 0, 0, grid.length);
    }

    private Node constructNode(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }
        Node nodeTL = constructNode(grid, x, y, len / 2);
        Node nodeTR = constructNode(grid, x, y + len / 2, len / 2);
        Node nodeBL = constructNode(grid, x + len / 2, y, len / 2);
        Node nodeBR = constructNode(grid, x + len / 2, y + len / 2, len / 2);
        if (nodeTL.isLeaf && nodeTR.isLeaf && nodeBL.isLeaf && nodeBR.isLeaf) {
            if (nodeTL.val && nodeTR.val && nodeBL.val && nodeBR.val) {
                return new Node(true, true, null, null, null, null);
            }
            if (!nodeTL.val && !nodeTR.val && !nodeBL.val && !nodeBR.val) {
                return new Node(false, true, null, null, null, null);
            }
        }
        return new Node(true, false, nodeTL, nodeTR, nodeBL, nodeBR);
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
