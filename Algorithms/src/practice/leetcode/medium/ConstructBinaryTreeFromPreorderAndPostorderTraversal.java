package practice.leetcode.medium;

/**
 * @tree
 *
 *            1
 *         /    \
 *       2       3
 *      / \     / \
 *     4   5   6   7
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1], Output: [1,2,3,4,5,6,7]
 *
 * preorder: root -> left -> right
 * postorder: left -> right -> root
 * pre:  1 (2 4 5) (3 6 7)
 * post: (4 5 2) (6 7 3) 1
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) return null;
        if (preStart == preEnd) return new TreeNode(pre[preStart]);
        TreeNode node = new TreeNode(pre[preStart]);
        int leftVal = pre[preStart + 1];
        int i = postStart;
        for (; i < postEnd; i++) {
            if (post[i] == leftVal) break;
        }
        node.left = construct(pre, preStart + 1, preStart + 1 + i - postStart, post, postStart, i);
        node.right = construct(pre, preStart + 2 + i - postStart, preEnd, post, i + 1, postEnd - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] po = {4,5,2,6,7,3,1};
        ConstructBinaryTreeFromPreorderAndPostorderTraversal c = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        c.constructFromPrePost(pre, po);
    }
}
