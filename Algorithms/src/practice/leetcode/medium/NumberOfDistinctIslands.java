package practice.leetcode.medium;

/*
1 1 0 1 1
1 0 0 0 0
0 0 0 0 1
1 1 0 1 1
result 3
 */

import java.util.*;

/**
 * @string
 * @search
 *
 * problems to solve:
 * 1. need a special identifier to track each island and its shape
 * 2. remove the duplicates
 *
 * traverse the island - dfs
 *
 */
public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i - 1, j, sb, "u");
        dfs(grid, i + 1, j, sb, "d");
        dfs(grid, i, j - 1, sb, "l");
        dfs(grid, i, j + 1, sb, "r");
        sb.append("b"); // back
    }

    public static void main(String[] args) {
        int[][] in = {  {1,1,0,1,1},
                        {1,1,0,1,0},
                        {0,0,0,1,1},
                        {1,1,0,1,1}};
        NumberOfDistinctIslands n = new NumberOfDistinctIslands();
        System.out.println(n.numDistinctIslands(in));
    }
}
