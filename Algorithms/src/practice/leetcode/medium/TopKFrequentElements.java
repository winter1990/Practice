package practice.leetcode.medium;

import java.util.*;

/**
 * @sort
 * @bucketsort
 *
 * get freq for each element
 * put into bucket (size? n+1) 11223/12345,2
 * scan through the bucket from last (biggest freq)
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int v : map.keySet()) {
            if (buckets[map.get(v)] == null) buckets[map.get(v)] = new ArrayList<>();
            buckets[map.get(v)].add(v);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] != null) res.addAll(buckets[i]);
        }
        return res;
    }

    /**
     * time:
     * O(n + nlogn + klogn)
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i : map.keySet()) {
            q.offer(new int[]{i, map.get(i)});
            if (q.size() > k) q.poll();
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!q.isEmpty()) {
            res.addFirst(q.poll()[0]);
        }
        return res;
    }
}
