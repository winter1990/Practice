package practice.leetcode.easy;

import java.util.*;

/**
 * @graph
 *
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path,
 * they have different types of flowers.
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.
 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 *
 * need to use a map to track the bi-direction path
 */
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) map.put(i, new HashSet<>());
        for (int[] p : paths) {
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        int[] res = new int[N];
        Set<Integer> colors;
        for (int i = 1; i <= N; i++) {
            colors = new HashSet<>();
            for (int c = 1; c <= 4; c++) colors.add(c);
            for (int nei : map.get(i)) {
                if (colors.contains(res[nei - 1])) colors.remove(res[nei - 1]);
            }
            res[i - 1] = colors.iterator().next();
        }
        return res;
    }
}
