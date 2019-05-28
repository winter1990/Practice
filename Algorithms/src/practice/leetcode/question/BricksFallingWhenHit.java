package practice.leetcode.question;

/**
 * @dfs
 *
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.
 * A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way)
 * adjacent bricks will not drop.
 * An erasure may refer to a location with no brick - if it does, no bricks drop.
 *
 *
 *
 */
public class BricksFallingWhenHit {
    final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        removeAllHits(grid, hits);
        markBricksAttachedToRoof(grid, m, n);
        int[] res = new int[hits.length];
        countBricksForEachHit(grid, hits, m, n, res);
        return res;
    }

    private void countBricksForEachHit(int[][] grid, int[][] hits, int m, int n, int[] res) {
        for (int k = hits.length - 1; k >= 0; k--) {
            int x = hits[k][0], y = hits[k][1];
            grid[x][y]++;
            if (grid[x][y] == 1 && isAttachedToRoof(grid, x, y, m, n)) {
                res[k] = dfs(grid, x, y, m,  n) - 1;
            }
        }
    }

    private boolean isAttachedToRoof(int[][] grid, int i, int j, int m, int n) {
        if (i == 0) return true;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 2) return true;
        }
        return false;
    }

    private boolean isValidPoint(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private void markBricksAttachedToRoof(int[][] grid, int m, int n) {
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j, m, n);
        }
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        return 1 + dfs(grid, i + 1,  j, m, n) + dfs(grid, i - 1,  j, m, n) + dfs(grid, i,  j + 1, m, n) + dfs(grid, i,  j - 1, m, n);
    }


    private void removeAllHits(int[][] g, int[][] h) {
        for (int i = 0; i < h.length; i++) {
            g[h[i][0]][h[i][1]]--;
        }
    }

    public static void main(String[] args) {
        BricksFallingWhenHit b = new BricksFallingWhenHit();
        int[][] in = {
                {0,1,1,1,1,1},
                {1,1,1,1,1,1},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}};
        int[][] hi = {{1,3},{3,5},{0,3},{3,3},{1,1},{4,2},{1,0},{3,0},{4,5},{2,1},{4,4},{4,0},{2,4},
                {2,5},{3,4},{0,5},{0,4},{3,2},{1,5},{4,1},{2,2},{0,2}};
        b.hitBricks(in, hi);
    }
}
