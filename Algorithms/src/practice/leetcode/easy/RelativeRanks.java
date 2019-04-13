package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * sort from high to low
 *
 * [8 10 6 2 5 3]
 * [10 8 6 5 3 2]
 * [G  S B 4 5 6]
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] rankigns = nums.clone();
        int len = nums.length;
        Arrays.sort(rankigns); // ascending order
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(rankigns[i], len - i);
        }
        String[] res = new String[len];
        for (int i = 0 ; i < len; i++) {
            int ranking = map.get(nums[i]);
            if (ranking == 1) {
                res[i] = "Gold Medal";
            } else if (ranking == 2) {
                res[i] = "Silver Medal";
            } else if (ranking == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = "" + map.get(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {5, 4, 3, 2, 1};
        RelativeRanks rr = new RelativeRanks();
        rr.findRelativeRanks(in);
    }
}
