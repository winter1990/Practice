package practice.leetcode.hard;

import java.util.Arrays;

/**
 * @array
 * @segmenttree
 * @daq
 * @bst
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * You need to return the number of important reverse pairs in the given array.
 *
 * Input: [2,4,3,5,1], Output: 3
 *
 * brute force:
 * for i = [1,n-2]
 *   for j = [i+1,n-1]
 *     compare and count
 *
 * optimization:
 * use a binary tree to store number of values that smaller than target
 *
 * scan from right to left
 * search in the tree to find smaller than nums[i]/2, add to the result
 * insert nums[i] into the tree
 * define a customized node - count represents count of numbers smaller or equal to current number
 *
 * search
 *   if target > node.val, all the left nodes in left subtree are smaller, so add current count + traverse right subtree
 *   else go to left subtree
 *
 * insertion
 * recursively traverse down the tree
 *   if null, create new node
 *   if equal to node.val, count++
 *   when traversing down to left subtree, update the count of current node
 */
public class ReversePairs {
    /**
     * merge sort
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && (double) nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return count;
    }

    /**
     * build tree
     */
    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0, n = nums.length;
        Node root = new Node(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            res += getCount(root, nums[i] / 2.0);
            insert(root, nums[i]);
        }
        return res;
    }

    private Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (root.val == val) {
            root.count++;
        } else if (val < root.val) {
            root.count++;
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private double getCount(Node root, double v) {
        if (root == null) return 0;
        if (v > root.val) {
            return root.count + getCount(root.right, v);
        } else {
            return getCount(root.left, v);
        }
    }

    class Node {
        int val, count;
        Node left, right;
        public Node(int v) {
            this.val = v;
            count = 1;
        }
    }

    /**
     * brute force
     */
    public int reversePairs2(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long a = nums[i];
                long b = (long) nums[j] * 2;
                if (a > b) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePairs r = new ReversePairs();
        int[] in = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(r.reversePairs1(in));
    }
}
