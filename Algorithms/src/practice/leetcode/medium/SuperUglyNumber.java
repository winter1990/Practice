package practice.leetcode.medium;

import java.util.TreeSet;

/**
 * @math
 * @heap
 *
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Input: n = 12, primes = [2,7,13,19], Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 *
 * problems to solve:
 * 1. all the factors must be in the prime list array
 * 2. always get the smallest, multiply the primes
 * 3. duplicates
 *
 * TreeSet
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long l = set.pollFirst();
            for (int p : primes) set.add(l * p);
        }
        return set.first().intValue();
    }
}
