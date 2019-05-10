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
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<>();
            }
            bucket[map.get(key)].add(key);
        }
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        return res;
    }

    /**
     * time complexity:
     * O(n + nlogn + klogn)
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int v : map.keySet()) pq.offer(new int[]{v, map.get(v)});
        List<Integer> res = new LinkedList<>();
        while (k-- > 0) res.add(pq.poll()[0]);
        return res;
    }
}
