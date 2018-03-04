package practice.leetcode.ez;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 *
 * scan, get largest freq. get max. narrow down the width.
 * => wrong, because multiple # have same freq
 *
 * use maps to keep track of left, right and freq
 */

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> l = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (l.get(nums[i]) == null) {
                l.put(nums[i], i);
            }
            r.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        int max = Collections.max(count.values());
        for (int i : count.keySet()) {
            if (count.get(i) == max) {
                res = Math.min(res, r.get(i) - l.get(i) + 1);
            }
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

        /*
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int freq = map.get(nums[i]);
                max = Math.max(max, freq + 1);
                map.put(nums[i], freq + 1);
            }
        }
        int target = 0;
        for (int n : map.keySet()) {
            if (map.get(n) == max) {
                target = n;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (nums[left] != target) {
            left++;
        }
        while (nums[right] != target) {
            right--;
        }
        return right - left + 1;
    }
    */
}
