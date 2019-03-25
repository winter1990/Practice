package practice.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @array
 * @search
 *
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents
 * the tree's height.
 *
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with
 * lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees.
 *
 * [1,2,3],
 * [0,0,4],
 * [7,6,5]
 * Output: 6
 *
 * the trees should be cut in order
 * start from point [0,0], walk to the lowest first lowest, second lowest -> use heap to store all the trees position
 * heap stores int[]{row, col, height}
 * bfs to find the closest path to next tree
 * cannot step on 0, but can walk through all positive values (grass, trees)
 *
 */
public class CutOffTreesForGolfEvent {
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int m = forest.size(), n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) pq.offer(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        int[] start = new int[]{0, 0};
        int total = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int steps = getSteps(forest, start, next, m, n);
            if (steps < 0) return -1;
            total += steps;
            start[0] = next[0];
            start[1] = next[1];
        }
        return total;
    }

    private int getSteps(List<List<Integer>> forest, int[] start, int[] des, int m, int n) {
        int steps = 0;
        boolean[][] isVisited = new boolean[m][n];
        isVisited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == des[0] && cur[1] == des[1]) return steps;
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y] || forest.get(x).get(y) == 0) continue;
                    q.offer(new int[]{x, y});
                    isVisited[x][y] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}
