package practice.leetcode.medium;

import java.util.TreeSet;

/**
 * @math
 * @dp
 *
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * problems to solve:
 * 1. ordered
 * 2. duplicates
 * 3. nth
 *
 * tree set can help with removing duplicates and the elements are ordered
 * 1 2 3 multiply 2 3 5 respectively
 */
public class UglyNumber_II {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long l = set.pollFirst();
            set.add(l * 2);
            set.add(l * 3);
            set.add(l * 5);
        }
        return set.first().intValue();
    }
}
