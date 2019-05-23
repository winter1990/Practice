package practice.leetcode.easy;

import java.util.PriorityQueue;

/**
 * @array
 * @greedy
 *
 * to get the heaviest, use a heap to store all the stones
 * define a max heap
 * put all stones in the heap
 * if there are two, take them out, compare the put the > 0 stone in the heap
 * check if there is a stone left
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int w : stones) pq.offer(w);
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 > s2) pq.offer(s1 - s2);
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
