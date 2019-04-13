package practice.leetcode.easy;

import java.util.TreeMap;

public class NumberOfRecentCalls {
}

class RecentCounter {
    TreeMap<Integer, Integer> map;
    public RecentCounter() {
        map = new TreeMap<>();
    }

    public int ping(int t) {
        if (map.floorKey(t) == null) {
            map.put(t, 1);
        } else {
            map.put(t, map.get(map.floorKey(t)) + 1);
        }
        return map.get(t) - map.get(map.ceilingKey(t - 3000)) + 1;
//        map.put(t, 1 + map.size());
//        return map.tailMap(t - 3000).size();

//        ts.add(t); // treeset
//        return ts.tailSet(t - 3000).size();

//        q.offer(t); // queue
//        while (q.peek() < t - 3000) { q.poll(); }
//        return q.size();
    }

}