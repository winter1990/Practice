package practice.leetcode.ez;

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
 * potentially, there might be multiple elements that have the same largest frequency, and we need to get the smallest window
 * need a map to track the leftmost index of all the elements in array
 * need a map to track the occurrence of the numbers
 * current degree - max occurrences
 * result -> minimum length
 * i = [0,n-1] if new element (not exists) in leftmost map, put value-index
 * if counter >= degree, update result
 * else update occurrence value
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
}
