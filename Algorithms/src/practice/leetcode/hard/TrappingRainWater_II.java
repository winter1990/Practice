package practice.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @search
 * @heap
 *
 * condition to hold water:
 * - the height is lower than 4 directions
 * - the outer layer decides how much it can hold
 *
 * steps:
 * - start from the outer most layer (initialize and put in queue)
 * - where to start? smallest value determines (priority queue)
 * - need to define the cell, with row, col, height
 * - compare the value,
 */
public class TrappingRainWater_II {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            isVisited[i][0] = true;
            isVisited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int j = 1; j < n - 1; j++) {
            isVisited[0][j] = true;
            isVisited[m - 1][j] = true;
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        int res = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int[] dir : dirs) {
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !isVisited[row][col]) {
                    res += Math.max(0, cur.height - heightMap[row][col]);
                    pq.offer(new Cell(row, col, Math.max(cur.height, heightMap[row][col])));
                    isVisited[row][col] = true;
                }
            }
        }
        return res;
    }

    class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int[][] in = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}};
        TrappingRainWater_II t = new TrappingRainWater_II();
        t.trapRainWater(in);
    }
}
