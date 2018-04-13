package practice.leetcode.medium;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class DesignHitCounter {
}

class HitCounter {
    TreeMap<Integer, Node> map;
    Node cur;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<>();
        cur = new Node(0);
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (map.containsKey(timestamp)) {
            map.get(timestamp).frequency++;
        } else {
            Node node = new Node(timestamp);
            node.frequency = cur.frequency + 1;
            map.put(timestamp, node);
            cur.next = node;
            cur = cur.next;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int cur = map.floorKey(timestamp) == null ? 0 : map.get(map.floorKey(timestamp)).frequency;
        int pre = map.floorKey(timestamp - 300) == null ? 0 : map.get(map.floorKey(timestamp - 300)).frequency;
        return cur - pre;
    }

    class Node {
        Node next;
        int frequency;
        int timestamp;
        public Node(int t) {
            timestamp = t;
            frequency = 0;
        }
    }

    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
        hc.hit(1);
        hc.hit(2);
        hc.hit(3);
//        hc.hit(3);
//        hc.hit(3);
        hc.hit(300);

        System.out.println(hc.getHits(301));
    }
}