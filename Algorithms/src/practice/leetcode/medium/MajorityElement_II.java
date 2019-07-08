package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @array
 *
 * Given an integer array of size n, find all elements that appear more than n/3 times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * method 1 - map and linear search
 * use map to keep track of the frequency, if freq > n/3, add to result
 * O(N), O(N)
 *
 * method 2
 * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
 * [1 2 3 1 3 1 2 2]
 * with the same thinking of Boyer-Moore Algorithm
 *   the array is unsorted
 *   there might be 1 or 2 elements that is more than 1/3
 *   if 1 or 2 numbers appear more than n/3 times, all other numbers appearance combined is smaller than any of them
 *
 * define two candidates and two counters
 *   initially, the two candidates are first and second element
 *   so if a different value appears, subtract by 1 for both of the counters
 *   but potential there might be only 1 or no number frequency more than n/3 [1 2 3 4 5 6 7 8 8]
 *   so at last, scan once again to check the frequency
 */
public class MajorityElement_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int c1 = nums[0], c2 = nums[0];
        int f1 = 0, f2 = 0;
        for (int i : nums) {
            if (i == c1) {
                f1++;
            } else if (i == c2) {
                f2++;
            } else if (f1 == 0) {
                c1 = i;
                f1 = 1;
            } else if (f2 == 0) {
                c2 = i;
                f2 = 1;
            } else {
                f1--;
                f2--;
            }
        }
        f1 = 0;
        f2 = 0;
        for (int i : nums) {
            if (i == c1) f1++;
            if (i == c2) f2++;
        }
        if (f1 > nums.length / 3) res.add(c1);
        if (f2 > nums.length / 3 && c1 != c2) res.add(c2);
        return res;
    }

    public static void main(String[] args) {
//        int[] in = {2,1,4,3,2,3,3,2};
//        MajorityElement_II me = new MajorityElement_II();
//        System.out.println(me.majorityElement(in));
        int[] in = {4,2,1,1};
        System.out.println(majorityElement1(in));
    }

    public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> candidates = new ArrayList<>();
        int n = nums.length;
        candidates.add(nums[n / 3]);
        candidates.add(nums[2 * n / 3]);
        for (int i : candidates) {
            int left = searchLeft(nums, i);
            int right = searchRight(nums, i);
            if (right - left + 1 > n / 3 && !res.contains(i)) res.add(i);
        }
        return res;
    }

    private static int searchLeft(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > target) {
                hi = mid - 1;
            } else if (a[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid > 0 && a[mid - 1] == target) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return lo;
    }

    private static int searchRight(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > target) {
                hi = mid - 1;
            } else if (a[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid < a.length - 1 && a[mid + 1] == target) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return lo;
    }
}
