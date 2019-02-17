package practice.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @hasmap
 *
 * row by row, calculate the ending coordinate
 * scan the map again to get the most frequency of the value
 * size of the wall - maxFreq
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (List<Integer> list : wall) {
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            sum = 0;
        }
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return wall.size() - max;
    }
}
