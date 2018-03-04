package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
}

class MapSum {

    /** Initialize your data structure here. */
    Map<String, Integer> map;
    public MapSum() {
        map  = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String s : map.keySet()) {
            if (s.indexOf(prefix) == 0) {
                sum += map.get(s);
            }
        }
        return sum;
    }
}