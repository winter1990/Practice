package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @heap
 *
 * You have k lists of sorted integers in ascending order.
 * Find the smallest range that includes at least one number from each of the k lists.
 *
 * the thinking is the same as merge k sorted lists:
 * use an integer array to store:
 *   index of list
 *   index of element in list
 *   value
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[2] - i2[2]);
        int range = Integer.MAX_VALUE, l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{i, 0, nums.get(i).get(0)});
            r = Math.max(r, nums.get(i).get(0));
        }
        int lo = -1, hi = -1;
        while (pq.size() == nums.size()) {
            int[] cur = pq.poll();
            if (r - cur[2] < range) {
                range = r - cur[2];
                lo = cur[2];
                hi = r;
            }
            if (cur[1] + 1 < nums.get(cur[0]).size()) {
                cur[1] += 1;
                cur[2] = nums.get(cur[0]).get(cur[1]);
                pq.offer(cur);
                if (cur[2] > r) r = cur[2];
            }
        }
        return new int[]{lo, hi};
    }

    public static void main(String[] args) {
        SmallestRange s = new SmallestRange();
        List<List<Integer>> in = new ArrayList<>();
        int[][] a = new int[][]{{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        for (int i = 0; i < a.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                l.add(a[i][j]);
            }
            in.add(l);
        }
        s.smallestRange(in);
    }
}