package practice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @search
 * @sort
 *
 * method 1
 * Arrays.sort(arr) and find the value arr[n - k] - O(nlogn) and O(1)
 *
 * method 2
 * PriorityQueue
 * maintain a K size queue -> min heap
 * for each element, put in queue, if the size is larger than K, then poll from the pq (smallest)
 * provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add)
 * linear time for the remove(Object) and contains(Object) methods;
 * and constant time for the retrieval methods (peek, element, and size).
 * O(logn + (n-k)logn) and O(k)
 */
public class KthLargestElementInAnArray {

    // sort and select N(nlogn)
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // priority queue
    // https://stackoverflow.com/questions/5695017/priorityqueue-not-sorting-on-add
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * @quickselect
     *
     * https://en.wikipedia.org/wiki/Quickselect
     * the quick select idea is to select a pivot, and move all the values larger than pivot to right and smaller to left
     * worst case: O(N^2), O(n) time
     */
    public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // k is the index we are looking for
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
