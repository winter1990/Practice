package practice.leetcode.hard;

import java.util.Arrays;

/**
 * @array
 *
 * Given an integer array, return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 * bucket sort:
 * scan once to get hi and lo, create (hi - lo) of bucket
 * O(n^2) to get all the difference, put in bucket
 * from [0, n-1] get
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int lo = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) lo = Math.min(lo, nums[i + 1] - nums[i]);
        int hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countPairs(nums, mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int countPairs(int[] a, int mid) {
        int n = a.length, res = 0, j = 0;
        for (int i = 0; i < n - 1; i++) {
            while (j < n && a[j] - a[i] <= mid) j++;
            res += j - i - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        FindKthSmallestPairDistance f = new FindKthSmallestPairDistance();
        System.out.println(f.smallestDistancePair(new int[]{1,3,1}, 1));
    }

    public int smallestDistancePair1(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        int[] bucket = new int[max - min + 1];
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                bucket[nums[j] - nums[i]]++;
            }
        }
        int index = 0;
        while (k > bucket[index]) {
            k -= bucket[index];
            index++;
        }
        return index;
    }
}
