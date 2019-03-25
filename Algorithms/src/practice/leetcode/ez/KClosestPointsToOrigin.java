package practice.leetcode.ez;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @heap
 * @daq
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * method 1
 * the distance to the original points -> sqrt(p[0]^2 + p[1]^2)
 * define the comparator, sort the points based on distance
 * time O(NlogN)
 * we sort all the points which is unnecessary
 *
 * method 2
 * maintain a heap with size of K
 * max or min heap? we want the smallest K points in the heap
 * so when size of heap > K, we want to poll the largest from the heap -> use max heap
 * time O(NlogK)
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) pq.poll();
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) res[i] = pq.poll();
        return res;
    }
}