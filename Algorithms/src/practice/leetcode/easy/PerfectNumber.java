package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself
 * Input: 28  Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 *
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                set.add(i);
                if (i != 1) {
                    set.add(num / i);
                }
            }
        }
        int sum = 0;
        for (int n : set) {
            sum += n;
        }
        return sum == num;
    }
}
