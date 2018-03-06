package practice.leetcode.medium;

/**
 * bfs
 * use queue to track neighbors - no backtracking
 * if value bigger, stop searching
 * 4 directions
 * out of boundary
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, m, n);
                }
            }
        }
        printArr(rooms);
    }

    private void dfs(int[][] rooms, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (rooms[i][j] == -1) {
            return;
        }
        if (i - 1 >= 0) {
            if (rooms[i - 1][j] > rooms[i][j] + 1) {
                rooms[i - 1][j] = rooms[i][j] + 1;
                dfs(rooms, i - 1, j, m, n);
            }
        }
        if (i + 1 < m) {
            if (rooms[i + 1][j] > rooms[i][j] + 1) {
                rooms[i + 1][j] = rooms[i][j] + 1;
                dfs(rooms, i + 1, j, m, n);
            }
        }
        if (j - 1 >= 0) {
            if (rooms[i][j - 1] > rooms[i][j] + 1) {
                rooms[i][j - 1] = rooms[i][j] + 1;
                dfs(rooms, i, j - 1, m, n);
            }
        }
        if (j + 1 < n) {
            if (rooms[i][j + 1] > rooms[i][j] + 1) {
                rooms[i][j + 1] = rooms[i][j] + 1;
                dfs(rooms, i, j + 1, m, n);
            }
        }
    }

    public static void main(String[] args) {
        int inf = 2147483647;
        int[][] in = new int[][]{{inf,-1,0,inf},{inf,inf,inf,-1},{inf,-1,inf,-1,inf},{0,-1,inf,inf}};
        WallsAndGates wg = new WallsAndGates();
        wg.wallsAndGates(in);
    }

    void printArr(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
}
