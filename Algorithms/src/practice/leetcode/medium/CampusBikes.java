package practice.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @array
 * @heap
 *
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M.
 * Each worker and bike is a 2D coordinate on this grid.
 *
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike)
 * pair with the shortest Manhattan distance between each other, and assign the bike to that worker.
 * (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the
 * smallest worker index;
 * if there are multiple ways to do that, we choose the pair with the smallest bike index).
 * We repeat this process until there are no available workers.
 *
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 *
 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned
 *
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: [0,2,1]
 *
 * w . .
 * b w .
 * w b b
 */
public class CampusBikes {
    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < n; j++) {
                int[] bike = bikes[j];
                q.offer(new int[]{Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]), i, j});
            }
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Set<Integer> visitedBike = new HashSet<>();
        while (visitedBike.size() < n) {
            int[] cur = q.poll();
            if (res[cur[1]] == -1 && !visitedBike.contains(cur[2])) {
                res[cur[1]] = cur[2];
                visitedBike.add(cur[2]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] w = {{0,0},{1,1},{2,0}};
        int[][] b = {{1,0},{2,2},{2,1}};
        assignBikes(w,b);
    }
}
