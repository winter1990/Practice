package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @heap
 *
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 *
 * Then, we choose a subset S of these items, such that:
 *
 * |S| <= num_wanted
 * For every label L, the number of items in S with label L is <= use_limit.
 * Return the largest possible sum of the subset S.
 *
 */
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, Integer> limit = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < values.length; i++) {
            if (!limit.containsKey(labels[i])) limit.put(labels[i], 0);
            pq.offer(new int[]{values[i], labels[i]});
        }
        int max = 0, count = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (limit.get(cur[1]) < use_limit) {
                max += cur[0];
                limit.put(cur[1], limit.get(cur[1]) + 1);
                if (++count == num_wanted) break;
            }
        }
        return max;
    }
}
