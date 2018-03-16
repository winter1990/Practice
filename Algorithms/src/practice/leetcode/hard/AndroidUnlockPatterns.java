package practice.leetcode.hard;
/*
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Invalid move: 4 - 1 - 9 - 2
Valid move:   2 - 4 - 1 - 3 - 6
Valid move:   6 - 5 - 4 - 1 - 9 - 2
Valid move:   1 - 8

count the total number of unlock patterns of the Android lock screen,
which consist of minimum of m keys and maximum n keys
 */

/**
 * use an array with size of 10 * 10 to record if the move (i,j) is valid
 * if (1,3),(4,6)...(3,9), must also contain the integer in the middle
 * so we can use int[10][10] as the checker
 */
public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int[][] checker = new int[10][10];
        checker[1][3] = checker[3][1] = 2;
        checker[1][7] = checker[7][1] = 4;
        checker[3][9] = checker[9][3] = 6;
        checker[7][9] = checker[9][7] = 8;
        checker[1][9] = checker[9][1]
                = checker[2][8] = checker[8][2]
                = checker[3][7] = checker[7][3]
                = checker[4][6] = checker[6][4] = 5;
        boolean[] isVisited = new boolean[10];
        int res = 0;
        // 1 3 7 9 and 2 4 6 8 are symmetric
        for (int i = m; i <= n; i++) {
            res += dfs(checker, isVisited, 1, i - 1) * 4;
            res += dfs(checker, isVisited, 2, i - 1) * 4;
            res += dfs(checker, isVisited, 5, i - 1);
        }
        return res;
    }

    private int dfs(int[][] checker, boolean[] isVisited, int cur, int remain) {
        if (remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        isVisited[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!isVisited[i] && (checker[cur][i] == 0 || isVisited[checker[cur][i]])) {
                res += dfs(checker, isVisited, i, remain - 1);
            }
        }
        isVisited[cur] = false;
        return res;
    }
}
