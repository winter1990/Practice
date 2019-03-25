package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @array
 * @search
 *
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
 *
 * bfs
 * for each move, we can move at most 6 steps
 * if the cell we land on is non-negative, we can choose to go to that number
 * use queue to store all the next steps
 * if reach destination, then return step
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];

        int i = n - 1, j = 0, index = 0, dir = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            if (dir == 1 && j == n - 1) {
                i--;
                dir = -1;
            } else if (dir == -1 && j == 0) {
                i--;
                dir = 1;
            } else {
                j += dir;
            }
        }
        boolean[] isVisited = new boolean[n * n];
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        int start = arr[0] == -1 ? 0 : arr[0] - 1;
        q.offer(start);
        isVisited[start] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == n * n - 1) return step;
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
                    int des = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!isVisited[des]) {
                        q.offer(des);
                        isVisited[des] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
