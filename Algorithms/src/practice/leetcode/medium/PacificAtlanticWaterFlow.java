package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic
 */

public class PacificAtlanticWaterFlow {
    // bfs
    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacifica = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        // vertical
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, n - 1});
            pacifica[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        // horizontal
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i});
            aq.offer(new int[]{m - 1, i});
            pacifica[0][i] = true;
            atlantic[m - 1][i] = true;
        }
        bfs(matrix, pq, pacifica, m, n);
        bfs(matrix, aq, atlantic, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacifica[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> q, boolean[][] visited, int m, int n) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                q.offer(new int[]{x, y});
            }
        }
    }

    // dfs
    public List<int[]> pacificAtlantic1(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[] {i, j});
        return res;
    }

//    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
    /**
     * two 2d arrays, one for pacifica and one for atlantic
     * the algorithm does not work
     * as
     * {{1,2,3},
     *  {8,9,4},
     *  {7,6,5}}
     *  [2,1] is in the result as it can go right first and move to top
     */
    public List<int[]> pacificAtlantic2(int[][] matrix) {
        List<int[]> res= new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
           return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacifica = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacifica[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pacifica[0][i] = true;
            atlantic[m - 1][i] = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if ((matrix[i][j] >= matrix[i - 1][j] && pacifica[i - 1][j])
                        || (matrix[i][j] >= matrix[i][j - 1] && pacifica[i][j - 1])) {
                    pacifica[i][j] = true;
                }
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if ((matrix[i][j] >= matrix[i + 1][j] && atlantic[i + 1][j])
                        || (matrix[i][j] >= matrix[i][j + 1] && atlantic[i][j + 1])) {
                    atlantic[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacifica[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2,3},
                                 {8,9,4},
                                 {7,6,5}};
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
        for (int[] arr : p.pacificAtlantic(in)) {
            System.out.println(arr[0]+" " + arr[1] + ", ");
        }
    }
}
