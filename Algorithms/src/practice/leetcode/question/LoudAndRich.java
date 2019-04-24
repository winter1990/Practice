package practice.leetcode.question;

import java.util.*;

/**
 * @search
 * @array
 *
 * return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of
 * quiet[y]), among all people who definitely have equal to or more money than person x.
 * Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * Output: [5,5,2,5,4,5,6,7]
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int[] p : richer) map.get(p[1]).add(p[0]);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) res[i] = dfs(res, i, quiet, map);
        return res;
    }

    private int dfs(int[] res, int index, int[] quiet, Map<Integer, List<Integer>> map) {
        if (res[index] != -1) {
            return res[index];
        }
        res[index] = index;
        if (map.get(index).size() != 0) {
            for (int nei : map.get(index)) {
                int n = dfs(res, nei, quiet, map);
                if (quiet[n] < quiet[index]) {
                    res[index] = n;
                }
            }
        }
        return res[index];
    }

    public static void main(String[] args) {
        int[][] r = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] q = {3,2,5,4,6,1,7,0};
        LoudAndRich l = new LoudAndRich();
        System.out.println(l.loudAndRich(r, q));
    }
}
