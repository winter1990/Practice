package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60
 *
 * Input: [30,20,150,100,40], Output: 3
 * 30 % 60 = 30, 30->1
 * 20 % 60 = 20, 20->1
 * 150 % 60 = 30, 30->2
 * 100 % 60 = 40, 40->1
 * 40 % 60 = 40, 40->2
 * two sum -> sum % 60 = 0
 *
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t : time) {
            int target = (60 - t % 60) % 60;
            count += map.getOrDefault(target, 0);
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return count;
    }

    public int numPairsDivisibleBy601(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}
