package practice.leetcode.medium;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @hash
 * @array
 *
 * method 1
 * use map to track the freq of all the numbers
 * as we want to start from the smallest, use tree map
 * for each key in the tree, start from the last element in the group which is [key + W - 1 ~ key]
 * update the map by minus the value of entry [1 1 2 2 3 3]
 *
 * method 2
 * priority queue
 * min heap, start from the peek
 * poll W numbers from the queue and if not found, return false
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int f : map.keySet()) {
            if (map.get(f) > 0) {
                for (int i = W - 1; i >= 0; i--) {
                    int val = f + i;
                    if (map.get(f) > map.getOrDefault(val, 0)) return false;
                    map.put(val, map.get(val) - map.get(f));
                }
            }
        }
        return true;
    }

    public boolean isNStraightHand1(int[] hand, int W) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand) pq.offer(i);
        while (!pq.isEmpty()) {
            int start = pq.peek();
            for (int i = 0; i < W; i++) {
                int v = start + i;
                if (!pq.contains(v)) return false;
                pq.remove(v);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] in = {1,2,3,6,2,3,4,7,8};
        HandOfStraights h = new HandOfStraights();
        System.out.println(h.isNStraightHand(in, 3));
    }
}
