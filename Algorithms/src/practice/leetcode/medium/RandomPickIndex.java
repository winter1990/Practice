package practice.leetcode.medium;

import java.util.*;

/**
 * @math
 * @reservoirsampling
 */
public class RandomPickIndex {
    class Solution {
        Map<Integer, List<Integer>> map;
        int[] nums;
        Random rand;
        public Solution(int[] nums) {
            map = new HashMap<>();
            this.nums = nums;
            rand = new Random();
            for (int i = 0; i < nums.length; i++) map.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
        }

        public int pick(int target) {
            return map.get(target).get(rand.nextInt(map.get(target).size()));
        }
    }

    class Solution1 {
        int[] nums;
        Random rand;
        public Solution1(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        public int pick(int target) {
            int n = nums.length;
            int i = rand.nextInt(n);
            while (nums[i] != target) {
                i = rand.nextInt(n);
            }
            return i;
        }
    }

    class Solution3 {
        int[] nums;
        Random rand;
        public Solution3(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        public int pick(int target) {
            int res = -1, count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) continue;
                if (rand.nextInt(++count) == 0) res = i;
            }
            return res;
        }
    }
}
