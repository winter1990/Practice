package practice.leetcode.hard;

import java.util.*;

/**
 * @array
 * @dp
 *
 * Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
 * Note that the frog can only jump in the forward direction.
 *
 * determine if frog can jump onto the last stone
 * dp[i] represents whether can jump on the stone
 * another dp array is needed to track how many steps the frog can jump
 *
 * array -> list, index list
 * map -> (index od stone, set of index can jump to)
 * boolean[] -> can be reached
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0 || stones[0] != 0) return false;
        if (stones[1] != 1) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++) map.put(stones[i], new HashSet<>());
        map.get(1).add(1);
        for (int i = 1; i < n; i++) {
            int start = stones[i];
            if (map.keySet().contains(start)) {
                for (int step : map.get(start)) {
                    if (map.containsKey(start + step - 1) && step - 1 > 0) map.get(start + step - 1).add(step - 1);
                    if (map.containsKey(start + step)) map.get(start + step).add(step);
                    if (map.containsKey(start + step + 1)) map.get(start + step + 1).add(step + 1);
                }
            }
        }
        return map.get(stones[n - 1]).size() != 0;
    }

    public static void main(String[] args) {
        int[] in = {0,1,2,3,4,8,9,11};
        FrogJump fj = new FrogJump();
        System.out.println(fj.canCross(in));
    }
}
