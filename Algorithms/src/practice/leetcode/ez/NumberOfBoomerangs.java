package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * @math
 * @map
 *
 * a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k
 * the order of the tuple matters
 * [[0,0],[1,0],[2,0]]
 * => 2, [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] i : points) {
            for (int[] j : points) {
                if (j == i) {
                    continue;
                }
                int distance = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int dist : map.keySet()) {
                int val = map.get(dist);
                cnt += (val * (val - 1));
            }
            map.clear();
        }
        return cnt;
    }
}
