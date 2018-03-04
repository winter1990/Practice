package practice.leetcode;

/**
 * Input: 11
 * Output: 0
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 * 1-9 10-99 100-999 1000-9999
 */

public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        int c = 9;
        int start = 1;
        while (n > len * c) {
            n -= len * c;
            len += 1;
            c *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
