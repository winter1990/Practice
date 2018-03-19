package practice.leetcode.medium;

import practice.algorithmAndOOD.threadingAndMemory.HashCodeDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28 (25^5)
 * 3  00011
 * 10 01010
 * 5  00101
 * 25 11001
 * 2  00010
 * 8  01000
 *
 * int max, int ~max
 * find largest max and largest ~max & array[i]
 */
public class MaximumXORofTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whose left bits can XOR to max
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    // the solution is wrong because:
    // keep track of biggest number does not guarantee the XOR
    // 10 8 2 => 1010 1000 0010 => 8^2 = 10
    public int findMaximumXOR1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max) max = n;
            if (n < min) min = n;
        }
        int mask = ~max;
        int maxMask = 0;
        for (int n : nums) {
            if ((mask & n) > maxMask) {
                maxMask = n;
            }
        }
        if (maxMask == 0) return max ^ min;
        return max ^ maxMask;
    }

    public static void main(String[] args) {
        MaximumXORofTwoNumbersInAnArray m = new MaximumXORofTwoNumbersInAnArray();
        int[] in = {8, 10, 2}; // 1000 1010 0010, 10
                //{4,6,7}; // 100 110 111, 3
                //{2,4}; // 0100 0010, 6
                //{3, 10, 5, 25, 2, 8}; // 28
        System.out.println(m.findMaximumXOR(in));
    }
}
