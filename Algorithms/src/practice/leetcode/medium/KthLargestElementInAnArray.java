package practice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @search
 * @sort
 * @quickselect
 *
 * method 1 - sort and select
 * Arrays.sort(arr) and find the value arr[n - k] - O(nlogn) and O(1)
 *
 * method 2 - heap
 * maintain a K size queue -> min heap
 * for each element
 *   put in queue
 *   if the size is larger than K, then poll from the pq (smallest)
 * priority queue provides O(log(n)) for enqueing and dequeing methods (offer, poll, remove() and add)
 * linear time for the remove(Object) and contains(Object) methods;
 * and constant time for the retrieval methods (peek, element, and size).
 * O(logn + (n-k)logn) - O(nlogn)
 * O(k) space
 *
 * method 3 - quick select
 * select a pivot
 * move all the larger elements to the right
 * move all the smaller or equal elements to the left
 *
 */
public class KthLargestElementInAnArray {
    // sort and select N(nlogn)
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // priority queue
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            q.offer(n);
            if (q.size() > k) q.poll();
        }
        return q.peek();
    }

    // quick select
    public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] a, int start, int end, int k) {
        int left = start, pivot = a[end];
        for (int i = left; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, left, i);
                left++;
            }
        }
        swap(a, left, end);
        if (left == k) {
            return a[left];
        } else if (left > k) {
            return quickSelect(a, start, left - 1, k);
        } else {
            return quickSelect(a, left + 1, end, k);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] arr = {2,1,6,5,8,4,3,7};
        int[] arr = {3,2,1,5,6,4};
        KthLargestElementInAnArray ke = new KthLargestElementInAnArray();
        System.out.println(ke.findKthLargest3(arr,5));
    }
}
