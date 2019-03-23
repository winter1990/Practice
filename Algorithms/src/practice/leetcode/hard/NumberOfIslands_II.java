package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @graph
 * @unionfind
 *
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * typical union find problem
 * a list of roots. This helps us find the identifier of an island faster. If roots[c] = p means the parent of node c
 * is p, we can climb up the parent chain to find out the identifier of an island
 * root[root[roots[c]]]... until root[c] == c;
 * To transform the two dimension problem into the classic UF, perform a linear mapping:
 * int id = n * x + y;
 *
 */
public class NumberOfIslands_II {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        for (int[] p : positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;
            count++;

            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int neighbor = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[neighbor] == -1) continue;

                int rootNb = findIsland(roots, neighbor);
                if (root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) id = roots[id];
        return id;
    }
}
