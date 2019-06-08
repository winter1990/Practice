package practice.leetcode.hard;

import java.util.*;

/**
 * @array
 *
 * the format of the building [left right height]
 * sort by left bound, if same left bound, sort by height
 * convert [l r h] to [left height] and [right height]
 * need to distinguish the start point and end point
 *
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
 * the key point is to sort the points
 * [2 10] [3 15] [5 12] [7 15] [9 10] [12 12] [15 10] [19 8] [20 10] [24 8]
 */
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int pre = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (pre != cur) {
                res.add(Arrays.asList(h[0], cur));
                pre = cur;
            }
        }
        return res;
    }
}
