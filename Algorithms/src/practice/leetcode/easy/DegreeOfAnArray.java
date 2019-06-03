package practice.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 *
 * problems to solve:
 * 1. find the maximum frequency number(s) in the array
 * 2. find the minimum window that contains at least on maximum frequency number
 *
 * method 1
 * use a map to track the leftmost index of all elements
 * use a map to track the rightmost index of all elements
 * use a map to track the occurrence of the numbers and get the max frequency
 * for each number
 *   if it has the maximum frequency, get from left and right map to calculate length
 *
 * method 2
 * update the maximum and rightmost element at the same time
 * use a map to track the leftmost element and index
 * keep track of the occurrence for each number
 * keep track of the max frequency
 * if larger update freq and max
 * if same, compare and get smaller
 */

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> leftmost = new HashMap<>(), counter = new HashMap<>();
        int degree = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            leftmost.putIfAbsent(nums[i], i);
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if (counter.get(nums[i]) > degree) {
                res = i - leftmost.get(nums[i]) + 1;
                degree = counter.get(nums[i]);
            } else if (counter.get(nums[i]) == degree) {
                res = Math.min(res, i - leftmost.get(nums[i]) + 1);
            }
        }
        return res;
    }

    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> l = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!l.containsKey(nums[i])) l.put(nums[i], i);
            r.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        int max = Collections.max(count.values());
        for (int n : count.keySet()) {
            if (count.get(n) == max) res = Math.min(res, r.get(n) - l.get(n) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        int[] a1 = new int[]{1};
        int[] a2 = new int[]{1, 2, 2, 3, 1};
        int[] a3 = new int[]{3, 3, 4};
        System.out.println(degreeOfAnArray.findShortestSubArray(a1));
        System.out.println(degreeOfAnArray.findShortestSubArray(a2));
        System.out.println(degreeOfAnArray.findShortestSubArray(a3));
    }
}
