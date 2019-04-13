package practice.leetcode.easy;

/**
 * search:
 * start with 0,0 when find 1, start searching
 * use another array to determine if visited
 */


public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return searchHelper(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int searchHelper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }

        int c = 0;
        grid[i][j] = -1;

        c += searchHelper(grid, i - 1, j);
        c += searchHelper(grid, i + 1, j);
        c += searchHelper(grid, i, j - 1);
        c += searchHelper(grid, i, j + 1);
        return c;
    }


    /**
     * total number of boards:
     * 2->2*4-2*1=6 3->3*4-2*2
     * number of sqares * 4 - neighbor * 2
     */
    public int islandPerimeter1(int[][] grid) {
        int sq = 0;
        int neighbor = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sq++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbor++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return sq * 4 - neighbor * 2;
    }
}
