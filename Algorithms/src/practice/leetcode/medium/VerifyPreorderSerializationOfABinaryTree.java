package practice.leetcode.medium;

/**
 * @tree
 *
 * One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 *
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#", Output: true
 * Input: "1,#", Output: false
 * Input: "9,#,#,1", Output: false
 *
 * binary tree
 *   each node has at most two children
 *   int the string, each node has two children including null
 *
 * 9,3,4,#,#,1,#,#,2,#,6,#,#
 * number of nodes = number of null + 1 -> why
 * for each node, if it is:
 *   null, then it increase 1 indegree and 0 outdegree
 *   non-null, then it increase 1 indegree and 2 outdegree
 *
 *
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String n : nodes) {
            if (--diff < 0) return false;
            if (!n.equals("#")) diff+= 2;
        }
        return diff == 0;
    }

    public boolean isValidSerialization1(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1, i = 0;
        for (; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                --diff;
                if (diff == 0) break;
            } else {
                ++diff;
            }
        }
        return diff == 0 && i == nodes.length - 1 && nodes[i].equals("#");
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(v.isValidSerialization("#,7,6,9,#,#,#"));
    }
}
