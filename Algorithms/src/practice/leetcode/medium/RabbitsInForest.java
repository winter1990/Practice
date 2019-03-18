package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @math
 *
 * Input: answers = [1, 1, 2], Output: 5
 * Input: answers = [10, 10, 10], Output: 11
 * Input: answers = [], Output: 0
 *
 * 1 0 1 0 0 -> 5
 * 2 2 2 2 1 -> 8, 2 2 2 in one group 3, 2 in one group 3, 1 in one group 2
 * if n rabbits answer x
 *  if n % (x + 1) == 0, we need n / (x + 1) groups rabbits
 *  if n % (x + 1) != 0, we need n / (x + 1) + 1 or n / (x + 1) round up groups of x + 1 rabbits
 *  we can combine the two cases by (n + x) / (x + 1)
 */
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        if (answers.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : answers) map.put(a, map.getOrDefault(a, 0) + 1);
        int sum = 0;
        for (int i : map.keySet()) {
            sum += (map.get(i) + i) / (i + 1) * (i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        RabbitsInForest r = new RabbitsInForest();
        int[] in = {1,0,1,0,0};
        System.out.println(r.numRabbits(in));
    }
}
