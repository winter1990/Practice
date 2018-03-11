package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_III {
    public int[] singleNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                set.remove(n);
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int n : set) {
            res[index] = n;
            index++;
        }
        return res;
    }
}
