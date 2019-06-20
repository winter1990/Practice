package practice.leetcode.medium;

import java.util.*;

/**
 * @array
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
 * with sides parallel to the x and y axes.
 * If there isn't any rectangle, return 0.
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]] Output: 4
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]] Output: 2
 *
 * all values are positive
 * sides are parallel to x y axis only
 *   4 points form a rectangle - time complexity high
 *   use the property of sides are parallel to x and y axis
 *   two diagonals can form a rectangle
 *     if we choose two points with different row & col, and find the other two points
 *     p1 and p2, the other twp points are [p1[0] p2[1]] and [p2[0] p1[1]]
 *   group the points with same row
 *     map - integer and set
 *
 * p1 and p2 in points
 *   skip the points with same row and col
 *   look up in the map to see if other two poitns exists
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) map.computeIfAbsent(p[0], s -> new HashSet<>()).add(p[1]);
        int res = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p2[0]).contains(p1[1]) && map.get(p1[0]).contains(p2[1])) {
                    res = Math.min(res, calculateArea(p1, p2));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int calculateArea(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
    }

    /**
     * [1 0] [3 2], if it is diagonal, we are looking for another diagonal [1 2] [3 0]
     *
     * [[1,1],[1,3],[3,1],[3,3],[2,2]]
     *
     * TLE with large input array
     */
    public int minAreaRect1(int[][] points) {
        Set<String> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int[] a : points) {
            for (int[] b : points) {
                if (a[0] == b[0] || a[1] == b[1]) continue;
                int[] p1 = a, p2 = b;
                if (p2[0] < p1[0]) {
                    int[] tmp = p1;
                    p1 = p2;
                    p2 = tmp;
                }
                String diagonal1 = p1[0] + " " + p1[1] + " " + p2[0] + " " + p2[1];
                String diagonal2 = p1[0] + " " + p2[1] + " " + p2[0] + " " + p1[1];
                if (set.contains(diagonal1)) {
                    res = Math.min(res, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                } else {
                    set.add(diagonal2);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
//        int[][] in = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        int[][] in = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        MinimumAreaRectangle m = new MinimumAreaRectangle();
        System.out.println(m.minAreaRect1(in));
    }
}
