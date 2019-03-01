package practice.leetcode.medium;

/**
 * @search
 * @dfs
 * @graph
 *
 * Some of them are friends, while some are not. Their friendship is transitive in nature
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]] output 2 -> 0th and 1th students are in same circle, 2nd student is in his own group
 *
 * matrix[i][i] is always 1
 * we start from 0, visit each friend (value = 1) in the array
 * recursively visit the friend's friend, and we need extra array to store whether the person is visited or not
 * in recursive call - matrix, boolean array, and start person
 * for each friend in m[index]
 * if not visited and matrix[i][j] = 1, mark the friend as true
 *
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        boolean[] isVisited = new boolean[M.length];
        int circle = 0;
        for (int i = 0; i < M.length; i++) {
            if (!isVisited[i]) {
                dfs(M, isVisited, i);
                circle++;
            }
        }
        return circle;
    }

    private void dfs(int[][] m, boolean[] isVisited, int st) {
        for (int i = 0; i < m[0].length; i++) {
            if (m[st][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                dfs(m, isVisited, i);
            }
        }
    }
}
