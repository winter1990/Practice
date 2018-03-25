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
 * need a special identifier to check each island
 * 11,10 11 11 01,11
 * maintaining the whole rectangle is hard, need extra or a copy of original array
 * <p>
 * add the identifier when searching up down left right
 */
public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        for (String s : set) System.out.println(s);
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i - 1, j, sb, "u");   // up
        dfs(grid, i + 1, j, sb, "d");   // down
        dfs(grid, i, j - 1, sb, "l");   // left
        dfs(grid, i, j + 1, sb, "r");   // right
        sb.append("b");                        // back
    }

    public static void main(String[] args) {
        int[][] in = {  {1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,0,1,1},
                        {0,0,0,1,1}};
        NumberOfDistinctIslands n = new NumberOfDistinctIslands();
        System.out.println(n.numDistinctIslands(in));
    }
}
