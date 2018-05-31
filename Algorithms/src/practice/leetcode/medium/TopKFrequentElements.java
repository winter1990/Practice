package practice.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @sort
 *
 * bucket sort
 * get freq for each element
 * put into bucket (size? n+1) 11223/12345,2
 * scan through the bucket from last (biggest freq)
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new LinkedList<>();
            }
            bucket[map.get(key)].add(key);
        }
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
