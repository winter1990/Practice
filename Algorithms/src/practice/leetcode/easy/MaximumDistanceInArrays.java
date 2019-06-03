package practice.leetcode.easy;

import java.util.List;

/**
 * @array
 *
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different
 * arrays (each array picks one) and calculate the distance.
 *
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.
 *
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 *
 * problems to solve:
 * 1. two values must be from two different arrays
 * 2. keep track of the maximum and minimum
 *
 * keep track of the min and max
 */
public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0, min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.abs(min - arrays.get(i).get(arrays.get(i).size() - 1)));
            res = Math.max(res, Math.abs(max - arrays.get(i).get(0)));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return res;
    }
}
