package practice.leetcode.hard;

import java.util.*;

/**
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
 *
 * the key point is to sort the points
 * [2 10] [3 15] [5 12] [7 15] [9 10] [12 12] [15 10] [19 8] [20 10] [24 8]
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        // the result is a series of points to sketch the outline of the buildings
        List<int[]> heights = new ArrayList<>();
        // for each building, add start point and its height
        for (int[] b : buildings) {
            // add negative value to distinguish start point and end point of a building
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        // if two buildings have the same start point, sort by height (higher one first)
        // otherwise, sort by start point
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        // use a map to keep track of
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        // start/leftmost point from 0
        heightMap.put(0, 1);
        // for each building, always need to compare the height with previous building
        // if higher, add new point
        // if lower, keep drawing the previous height
        int prevHeight = 0;
        List<int[]> skyLine = new LinkedList<>();
        for (int[] h : heights) {
            if (h[1] < 0) {
                Integer cnt = heightMap.get(-h[1]);
                cnt = (cnt == null) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyLine.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
}
