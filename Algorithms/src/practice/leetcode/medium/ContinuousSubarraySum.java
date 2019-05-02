package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 *
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer pre = map.get(sum);
            if (pre != null) {
                if (i - pre > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum c = new ContinuousSubarraySum();
        System.out.println(c.checkSubarraySum(new int[]{0,1,0}, 7));
        System.out.println(c.checkSubarraySum(new int[]{1,0}, 2));
    }
}
