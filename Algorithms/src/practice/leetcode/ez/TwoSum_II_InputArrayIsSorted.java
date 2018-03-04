package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_II_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[2];
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i);
            } else {
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
            }
        }
        return res;
    }
}
