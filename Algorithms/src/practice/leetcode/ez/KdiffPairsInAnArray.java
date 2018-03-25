package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * similar idea of two sum
 * number can be reused
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * 1 5, -1 3, 2 6, contains but dont know its for -1 or 3
 *
 * store the number and index, can check only nums[i]+k
 * how to handle the duplicates:
 * 1 1 2 3, 1 => map: 10, 11, 11 22, 11 22 33, after counting, remove the entry nums[i]+k
 * 1 1 1 1, 0 => map: 13
 * 1, 0       => map: 10
 * 2 1, 1     => map: 20 11,
 */
public class KdiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
                cnt++;
                map.remove(nums[i] + k);
            }
        }
        return cnt;
    }

    // incorrect solustion as it does not handle duplcates number and k=0
    public int findPairs1(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (k != 0 && map.values().contains(i)) {
                continue;
            }
            if (map.containsKey(i)) {
                cnt++;
            }
            map.put(i + k, i);
            map.put(i - k, i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] in = //{1,1,1,1,1};
        {1, 3, 1, 5, 4};
//         {3, 1, 4, 1, 5, 3, 5};
//         {1, 2, 3, 4, 5};
        int d = 0;
        KdiffPairsInAnArray k = new KdiffPairsInAnArray();
        System.out.println(k.findPairs(in, d));
    }
}
