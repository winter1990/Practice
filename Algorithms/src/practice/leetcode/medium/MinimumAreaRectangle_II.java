package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @math
 *
 * Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points,
 * with sides not necessarily parallel to the x and y axes.
 * If there isn't any rectangle, return 0.
 *
 * to determine an rectangle, two diagonals should have the same length and middle point
 * group all the points with the same:
 *   center point
 *   length
 *   then the points within the same group can form a rectangle
 * map
 *   key - length and center point - len + " " + X + " " + Y
 *   value - a list of pairs / points - int[] size = 2, indicates the index in points
 * for the points in same group
 *   calculate area and update the min
 */
public class MinimumAreaRectangle_II {
    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> map = new HashMap();
        int m = points.length;
        if (m < 4) return 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] p1 = points[i], p2 = points[j];
                long len = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                double midX = (double) (p1[0] + p2[0]) / 2;
                double midY = (double) (p1[1] + p2[1]) / 2;
                String k = len + " " + midX + " " + midY;
                if (!map.containsKey(k)) map.put(k, new ArrayList<>());
                map.get(k).add(new int[]{i, j});
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() < 2) continue;
            List<int[]> list = map.get(key);
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] p1 = points[list.get(i)[0]];
                    int[] p2 = points[list.get(i)[1]];
                    int[] p3 = points[list.get(j)[0]];
                    double area = Math.sqrt((p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]))
                            * Math.sqrt((p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]));
                    min = Math.min(min, area);
                }
            }
        }
        if (min == Double.MAX_VALUE) min = 0;
        return min;
    }

    public static void main(String[] args) {
        int[][] in = {{1,2},{2,1},{1,3},{3,1},{0,3}};
        MinimumAreaRectangle_II m = new MinimumAreaRectangle_II();
        System.out.println(m.minAreaFreeRect(in));
    }
}
