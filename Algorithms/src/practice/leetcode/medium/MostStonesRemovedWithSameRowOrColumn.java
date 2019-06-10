package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 * @unionfind
 *
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * What is the largest possible number of moves we can make?
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]], Output: 5
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]], Output: 3
 *
 * translation:
 *   divide all the stones into groups
 *   count the number of groups
 *
 * the stones with same row OR col are in the same group
 * we need to mark the same group of stones with some id
 * the same group of stones are similar with a graph, if row / col same, then it is connected to the graph
 *
 * union find
 *   if two nodes are "adjacent", set them as the same root
 *   total n stones, if two stones have the different root, count-- (original value is n)
 *   number of islands = n - count
 *
 * initial status parent[i] = i, i = [0, n]
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int count = n;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] != stones[j][0] && stones[i][1] != stones[j][1]) continue;
                int p1 = find(parent, i);
                int p2 = find(parent, j);
                if (p1 != p2) {
                    parent[p2] = p1;
                    count--;
                }
            }
        }
        return n - count;
    }

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;
    public int removeStones1(int[][] stones) {
        for (int i = 0; i < stones.length; i++) union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn m = new MostStonesRemovedWithSameRowOrColumn();
        int[][] in = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        m.removeStones(in);
//        System.out.println(2);
//        System.out.println(~2);
    }

    /**
     * wrong solution
     * the order matters
     * [[0,1],[1,2],[1,3],[3,3],[2,3],[0,2]]
     * if we follow the order of stones added in input
    public int removeStones(int[][] stones) {
        int m = 0;
        int n = 0;
        for (int i = 0; i < stones.length; i++) {
            m = Math.max(m, stones[i][0]);
            n = Math.max(n, stones[i][1]);
        }
        int count = 0;
        int[] row = new int[m + 1], col = new int[n + 1];
        for (int i = 0; i < stones.length; i++) {
            row[stones[i][0]]++;
            col[stones[i][1]]++;
            count++;
        }
        for (int i = 0; i < stones.length; i++) {
            if (row[stones[i][0]] > 1 || col[stones[i][1]] > 1) {
                row[stones[i][0]]--;
                col[stones[i][1]]--;
            } else {
                count--;
            }
        }
        return count;
    }
     */
}
