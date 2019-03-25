package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @hash
 *
 * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum
 * is a perfect square.
 * Return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there
 * is some index i such that A1[i] != A2[i].
 *
 * Input: [1,17,8], Output: 2 Explanation: [1,8,17] and [17,8,1] are the valid permutations.
 * Input: [2,2,2], Output: 1
 *
 * count the occurrence of each number
 * get the candidates that can be the next number to it -> sqrt of i + j
 * dfs
 */
public class NumberOfSquarefulArrays {
    public int numSquarefulPerms(int[] A) {
        Map<Integer, Set<Integer>> candidate = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int[] res = new int[1];
        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
            candidate.putIfAbsent(a, new HashSet<>());
        }
        for (int n1 : count.keySet()) {
            for (int n2 : count.keySet()) {
                double v = Math.sqrt(n1 + n2);
                if (v == Math.floor(v)) {
                    candidate.get(n1).add(n2);
                    candidate.get(n2).add(n1);
                }
            }
        }
        for (int n : count.keySet()) {
            dfs(n, A.length - 1, count, candidate, res);
        }
        return res[0];
    }

    private void dfs(int n, int left, Map<Integer, Integer> count, Map<Integer, Set<Integer>> candidate, int[] res) {
        count.put(n, count.get(n) - 1);
        if (left == 0) {
            res[0]++;
        } else {
            for (int next : candidate.get(n)) {
                if (count.get(next) > 0) dfs(next, left - 1, count, candidate, res);
            }
        }
        count.put(n, count.get(n) + 1);
    }

    public static void main(String[] args) {
        int[] in = {1,17,8};
        NumberOfSquarefulArrays ns = new NumberOfSquarefulArrays();
        System.out.println(ns.numSquarefulPerms(in));
    }
}
