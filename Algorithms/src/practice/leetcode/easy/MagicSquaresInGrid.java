package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @array
 *
 * 5 must be in the center
 * distinct numbers from [1,9] in the 3*3 grid
 * each line sum is 15
 *
 */
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagicSquare(int[][] grid, int x, int y) {
        if (grid[x + 1][y + 1] != 5) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                if (!set.add(grid[i][j])) return false;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (!set.contains(i)) return false;
        }
        if (grid[x][y] + grid[x + 2][y + 2] != 10) return false;
        if (grid[x][y + 2] + grid[x + 2][y] != 10) return false;
        if (grid[x + 1][y] + grid[x + 1][y + 2] != 10) return false;
        if (grid[x][y + 1] + grid[x + 2][y + 1] != 10) return false;
        if (grid[x][y] + grid[x][y + 1] + grid[x][y + 2] != 15) return false;
        if (grid[x][y] + grid[x + 1][y] + grid[x + 2][y] != 15) return false;
        return true;
    }

    public static void main(String[] args) {
        MagicSquaresInGrid ms = new MagicSquaresInGrid();
        int[][] in = new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        ms.numMagicSquaresInside(in);
    }
}
