package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
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
        int[] arr = {5,2,6,1};
        System.out.println(c.countSmaller(arr));
    }

    /**
     * @array
     * @daq
     * @sementtree
     *
     * [5, 4, 2, 6, 1] => [3, 2, 1, 1, 0]
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
     */
    public List<Integer> countSmaller1(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(res);
        }
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = insertNode(root, nums[i]);
        }
        return Arrays.asList(res);
    }

    private Integer insertNode(Node node, int num) {
        int total = 0;
        while (node.val != num) {
            if (num < node.val) {
                if (node.left == null) {
                    node.left = new Node(num);
                }
                node.leftCount++;
                node = node.left;
            } else {
                total += (node.leftCount + node.count);
                if (node.right == null) {
                    node.right = new Node(num);
                }
                node = node.right;
            }
        }
        node.count++;
        return total + node.leftCount;
    }

    class Node {
        Node left;
        Node right;
        int val;
        int count;
        int leftCount;
        public Node(int val) {
            this.val = val;
            count = 0;
        }
    }
}
