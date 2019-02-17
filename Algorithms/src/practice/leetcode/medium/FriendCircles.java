package practice.leetcode.medium;

/**
 * @search
 * @dfs
 *
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]] output 2
 *
 * total people in M -> M.length
 * the graph is undirected
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] isVisited = new int[M.length];
        int circle = 0;
        for (int i = 0; i < M.length; i++) {
            if (isVisited[i] == 0) {
                dfs(M, isVisited, i);
                circle++;
            }
        }
        return circle;
    }

    private void dfs(int[][] m, int[] isVisited, int i) {
        for (int j = 0; j < m[0].length; j++) {
            if (m[i][j] == 1 && isVisited[j] == 0) {
                isVisited[j] = 1;
                dfs(m, isVisited, j);
            }
        }
    }
}
