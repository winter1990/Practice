package practice.leetcode.medium;

public class RangeSumQuery_Mutable {
}

/**
 * @array
 * @tree
 * @segmenttree
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * analysis of time complexity of segment tree vs. update the tree in linear:
 * for segment tree method, we are converting an array into a tree-structured form
 * recursively divide the array into left and right half
 * the root is the sum of all elements, left child is sum of left half subarray, the same for right half
 * to get sum in range [i, j]:
 *   segment tree will not speed up the getRange() because it always starts with the root and traverse down the tree
 *   time complexity is O(logN), the worst case is O(n)
 *   compare with method using array, which is O(1)
 * to update the element in array:
 *   based on the given index, find and update node which is a leaf node in the tree
 *   when we go up the tree, update the sum as well
 *   time complexity O(logN)
 *   compared to updating the value in the sum array, which is O(n)
 */
class NumArray {
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] a, int s, int e) {
        if (s > e) return null;
        SegmentTreeNode n = new SegmentTreeNode(s, e);
        if (s == e) {
            n.sum = a[s];
        } else {
            int mid = (s + e) / 2;
            n.left = buildTree(a, s, mid);
            n.right = buildTree(a, mid + 1, e);
            n.sum = n.left.sum + n.right.sum;
        }
        return n;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode n, int i, int v) {
        if (n.start == n.end) {
            n.sum = v;
            return;
        }
        int mid = (n.start + n.end) / 2;
        if (i > mid) {
            update(n.right, i, v);
        } else {
            update(n.left, i, v);
        }
        n.sum = n.left.sum + n.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode n, int s, int e) {
        if (n.start == s && n.end == e) return n.sum;
        int mid = (n.start + n.end) / 2;
        if (mid >= e) {
            return sumRange(n.left, s, e);
        } else if (s >= mid + 1) {
            return sumRange(n.right, s, e);
        } else {
            return sumRange(n.left, s, mid) + sumRange(n.right, mid + 1, e);
        }
    }

    class SegmentTreeNode {
        SegmentTreeNode left, right;
        int start, end, sum;
        public SegmentTreeNode(int s, int e) {
            start = s;
            end = e;
            sum = 0;
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,3,5,4,7,9};
        NumArray na = new NumArray(in);
        na.sumRange(0,2);
        na.update(1,6);
        na.sumRange(0,2);
    }
}
