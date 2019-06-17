package practice.interview.google;

/**
 * 2d array有灯塔和rock， 灯塔可以照亮所对应的所有行和列， 但是遇到rock之后rock后面的就不能照亮了， 最后求灯塔照的最亮的区域
 *
 * 0 0 0 1 0 2 0
 * 1 0 1 0 0 0 1
 * 0 0 2 0 2 0 1
 * 2 1 0 0 0 1 0
 * 1 1 1 0 1 1 0
 */
public class LightestAreaWithRocks {
    public int[] findLightestPoint(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int row = 0, col[] = new int[n];
        int max = 0;
        int[] res = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) continue;
                if (j == 0 || grid[i][j - 1] == 2) row = getRowCount(grid, i, j, n);
                if (i == 0 || grid[i - 1][j] == 2) col[j] = getColumnCount(grid, i, j, m);
                if (grid[i][j] == 0) {
                    if (row + col[j] > max) {
                        res[0] = i;
                        res[1] = j;
                        max = row + col[j];
                    }
                }
            }
        }
        return res;
    }

    private int getRowCount(int[][] grid, int i, int j, int n) {
        int count = 0;
        while (j < n && grid[i][j] != 2) {
            if (grid[i][j] == 1) count++;
            j++;
        }
        return count;
    }

    private int getColumnCount(int[][] grid, int i, int j, int m) {
        int count = 0;
        while (i < m && grid[i][j] != 2) {
            if (grid[i][j] == 1) count++;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] in = {
                {0, 0, 0, 1, 0, 2, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 0, 2, 1, 2, 0, 1},
                {2, 1, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 1, 0}};
        LightestAreaWithRocks l = new LightestAreaWithRocks();
        int[] res = l.findLightestPoint(in);
        System.out.println(res[0] + " " + res[1]);
    }
}
