package practice.leetcode.question;

/**
 * @bfs
 *
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.
 * A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way)
 * adjacent bricks will not drop.
 * An erasure may refer to a location with no brick - if it does, no bricks drop.
 *
 * when do a hit, then bfs for 4 directions
 * if not connected to ceiling, then it falls, count the isolated islands
 */
public class BricksFallingWhenHit {
    final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i : grid[0]) if (i == 0) count++;
        if (count == 0) return new int[hits.length]; // all bricks fall at the beginning boom

        boolean[] notValidHit = new boolean[hits.length];
        for (int i = 0; i < hits.length; i++) {
            if (grid[hits[i][0]][hits[i][1]] == 0) notValidHit[i] = true;
            grid[hits[i][0]][hits[i][1]] = 0;
        }

        int[] res = new int[hits.length];
        int index = res.length - 1;
        for (int i = hits.length - 1; i >= 0; i--) {
            int nei = countNeighbors(grid, hits[i][0], hits[i][1], m, n);
            if (nei >= 2) {
                boolean u = isConnectedToTop(grid, hits[i][0] - 1, hits[i][1]);
                boolean d = isConnectedToTop(grid, hits[i][0] - 1, hits[i][1]);
                boolean l = isConnectedToTop(grid, hits[i][0], hits[i][1] - 1);
                boolean r = isConnectedToTop(grid, hits[i][0], hits[i][1] + 1);

            }
        }
        return res;
    }

    private boolean isConnectedToTop(int[][] grid, int i, int j) {
        if (i == 0) return true;

        return false;
    }

    private boolean isValidPoint(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    private int countNeighbors(int[][] grid, int i, int j, int m, int n) {
        int count = 0;
        for (int[] dir : dirs) {
            if (i + dir[0] >= 0 && i + dir[0] < m && j + dir[1] >= 0 && j + dir[1] < n) {
                if (grid[i + dir[0]][j + dir[1]] == 1) count++;
            }
        }
        return count;
    }
}
