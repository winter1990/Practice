package practice.leetcode.ez;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @heap
 * @daq
 *
 * create
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int) (Math.pow(o1.x, 2) + Math.pow(o1.y, 2) - Math.pow(o2.x, 2) - Math.pow(o2.y, 2));
            }
        });
        for (int[] point : points) {
            pq.offer(new Point(point[0], point[1]));
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}