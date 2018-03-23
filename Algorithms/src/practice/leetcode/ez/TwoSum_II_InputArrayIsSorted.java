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
                break;
            }
        }
        return res;
    }

    // two pointers: 0 and len-1
    // compare with target value
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int s = 0;
        int e = numbers.length - 1;
        while (s < e) {
            int sum = numbers[s] + numbers[e];
            if (sum == target) {
                res[0] = s + 1;
                res[1] = e + 1;
                break;
            } else if (sum > target) {
                e--;
            } else {
                s++;
            }
        }
        return res;
    }
    // O(nlog) time, O(1) space
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int s = i + 1;
            int e = numbers.length - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                int val = target - numbers[i];
                if (numbers[mid] == val) {
                    int[] res = new int[2];
                    res[0] = i + 1;
                    res[1] = mid + 1;
                } else if (numbers[mid] > val) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return new int[2];
    }
}
