package practice.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 * 1. 4 points form a rectangle
 * 2. if we choose two points in the same row, and need to check each other row, and all the points
 * 3. but if we choose two points with different row & col. because rectangle is parralel to axis
 * 4. two points in diagonal will set the rectangle
 * 5. we are looking for the other two points with same row with one point and same col with another point
 * 6. use a map to group the points with same row (int, set)
 * 7. set two points (diff row && col), lookup in map
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p :  points) {
            if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
