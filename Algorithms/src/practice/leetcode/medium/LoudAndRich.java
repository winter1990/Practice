package practice.leetcode.medium;

import java.util.*;

/**
 * @search
 * @array
 *
 * return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of
 * quiet[y]), among all people who definitely have equal to or more money than person x.
 * Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * Output: [5,5,2,5,4,5,6,7]
 *
 * 0 [1 3]
 * 1 [2]
 * 2 []
 * 3 [4 5 6]
 * 4 []
 * 5 []
 * 6 []
 * 7 [3]
 * build the relation for each person, and find all the people richer
 * map<int,list> person,all the richer people
 * search all the neighbors and their neighbors to find the smallest value in quiet[]
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = quiet.length;
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int[] pair : richer) map.get(pair[1]).add(pair[0]);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            res[i] = dfs(map, quiet, i, res);
        }
        return res;
    }

    public int dfs(Map<Integer, List<Integer>> map, int[] q, int index, int[] res) {
        if (res[index] != -1) return res[index];
        res[index] = index;
        if (map.get(index).size() > 0) {
            for (int nei : map.get(index)) {
                int next = dfs(map, q, nei, res);
                if (q[next] < q[res[index]]) res[index] = next;
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
