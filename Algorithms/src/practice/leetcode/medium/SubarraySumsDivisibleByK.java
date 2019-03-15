package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 * Input: A = [4,5,0,-2,-3,1], K = 5, Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * 0 also counts
 * sum = 4, 4 % 5 = 4, count += map.get sum -> 0, put 4->1 in map
 * sum = 9, 9 % 5 = 4, count += map.get sum -> 1 sum = 1, update entry 4->2
 * sum = 4, 4 % 5 = 4, count += map.get sum -> 2 sum = 3, update entry 4->3
 * ....
 * sum -2 -3 = -1,
 *
 * brute force:
 * start from 0, 1,... scan all the element and calculate the sum, if mod by 5 = 0, count++
 *
 * in term of contiguous subarray, prefix is a common method
 * if sum[0,i] % k = sum[0,j] % k, then sum[i+1,j] mustb e divisible by k
 * for current j we need to find out how many index i < j exist that has the same value mod by k
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) sum += K;
            res += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,5,0,-2,-3,1};
        int k = 5;
        SubarraySumsDivisibleByK s = new SubarraySumsDivisibleByK();
        System.out.println(s.subarraysDivByK(a, k));
    }
}
