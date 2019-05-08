package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @search
 * @heap
 *
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
 * compute the volume of water it is able to trap after raining.
 *
 * condition to hold water:
 * 4 directions is not enough -> outer layer? -> outer layers -> outermost layer
 *
 * for 2D, we start from left and right most elements/bars
 * the same for 3D, because if we start from the middle, we need to scan through all the elements in matrix
 *
 * steps:
 * start from the outer most layer (initialize and put in queue)
 *   which cell to start - smallest height determines (think about bucket effect)
 *   always start from the smallest height cell - ordered - priority queue
 *   need to define the class cell(row, col, height)
 * BFS each cell in the queue
 *   search 4 directions
 *   if in bound and not visited
 *     if lower - water can be trapped, add to result
 *     otherwise - no water
 *     put cell in queue
 *
 */
public class TrappingRainWater_II {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> (c1.height - c2.height));
        int m = heightMap.length, n = heightMap[0].length;
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
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur.row + dir[0];
                int y = cur.col + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !isVisited[x][y]) {
                    res += Math.max(0, cur.height - heightMap[x][y]);
                    pq.offer(new Cell(x, y, Math.max(cur.height, heightMap[x][y])));
                    isVisited[x][y] = true;
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
