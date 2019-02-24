package practice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @search
 *
 * method 1
 * Arrays.sort(arr) and find the value arr[n - k] - O(nlogn) and O(1)
 *
 * method 2
 * PriorityQueue
 * enqueue the element in array and maintain a K size pq - O(logn + (n-k)logn) and O(k)
 * provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add)
 * linear time for the remove(Object) and contains(Object) methods;
 * and constant time for the retrieval methods (peek, element, and size).
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

    // https://en.wikipedia.org/wiki/Quickselect
    // O(n) time
    public int findKthLargest3(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];
    }

    // return the index of the kth smallest number
    private int quickSelect(int[] a, int lo, int hi, int k) {
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo;
        int j = hi;
        int pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) {
                swap(a, --i, --j);
            }
        }
        swap(a, i, hi);
        // count the nums that are <= pivot from lo
        int m = i - lo + 1;
        // pivot is the one!
        if (m == k) return i; // pivot is too big, so it must be on the left
        else if (m > k) return quickSelect(a, lo, i - 1, k); // pivot is too small, so it must be on the right
        else return quickSelect(a, i + 1, hi, k - m);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,6,5,8,4,3,7};
        KthLargestElementInAnArray ke = new KthLargestElementInAnArray();
        System.out.println(ke.findKthLargest3(arr,4));
    }
}
