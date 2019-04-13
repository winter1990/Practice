package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_WithDuplicates {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
//        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum_WithDuplicates twoSum_withDuplicates = new TwoSum_WithDuplicates();
        int[] input = {2,5,1,2,2,6};
        int target = 4;
        int[] res = twoSum_withDuplicates.twoSum(input, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
