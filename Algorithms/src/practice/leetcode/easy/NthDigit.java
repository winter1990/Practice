package practice.leetcode.easy;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * length of the number
 * find the number
 * find the result digit
 *
 * 299
 * -9=290  len=2 count=90 res=10
 * -90=200 len=3 count=900 res=100
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1; // length of the number
        long base = 9;
        int start = 1;
        while (n > len * base) {
            n -= len * base;
            len += 1; // 1-9 10-99
            start *= 10; // used when we want to find the target, 1-9=9numbers 10-99=90 100-999=900
            base *= 10;
        }
        int target = start + (n - 1) / len;
        int reminder = (n - 1) % len;
        return Character.getNumericValue((target + "").charAt(reminder));
    }
}
