package practice.leetcode.hard;

import java.util.*;

/**
 * @array
 * @daq
 * @sementtree
 *
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * [5, 4, 2, 6, 1] => [3, 2, 1, 1, 0]
 *
 *
 * use a tree-like data structure and track the visited numbers
 * from right most element: keep track how many elements are smaller than current node
 * [3, 2, 2, 6, 1]
 *        1 (0,1)
 *         \
 *          6 (3,1)
 *         /
 *        2 (0,2)
 *         \
 *          3 (0,1)
 * when traversing to left node, increase the count in the path
 *
 * [5 2 6 1]
 * start with last number - 1
 * set it as root
 * then i = [n-2,0]
 * get the count and insert the node nums[i]
 *
 * insertNode(node, new node value)
 *   if val <= node.val, need to go to left subtree and continue searching
 *     left child null - no values smaller than node.val
 *       as the current value we want to insert is smaller, so current node.count++
 *     left child not null - go to left node
 *   if val > node.val
 *     count += currentnode.count
 *     right child null - the value we want to insert is largest, add new node to right
 *     right child not null - go to right child
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(0);
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(0, count);
        }
        return res;
    }

    private int insertNode(Node node, int v) {
        int count = 0;
        while (true) {
            if (v <= node.val) {
                node.count++;
                if (node.left == null) {
                    node.left = new Node(v);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                count += node.count;
                if (node.right == null) {
                    node.right = new Node(v);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return count;
    }

    class Node {
        Node left, right;
        int count;
        int val;
        public Node(int val) {
            this.val = val;
            count = 1;
        }
    }

    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }
        return res;
    }

    private void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }
    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
        int[] arr = {3,2,2,4,1,};
        System.out.println(c.countSmaller1(arr));
    }



}
