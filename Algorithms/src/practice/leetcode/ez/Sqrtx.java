package practice.leetcode.ez;

/**
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * 4->2, 8->2
 *
 * from 1 to x, brute
 * binary search
 * mid^2=x mid
 * mid^2>x mid-1
 * mid^2<x mid-1
 * r is the value
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 1;
        long r = x / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long val = mid * mid;
            if (val == x) {
                return (int) mid;
            } else if (val > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }
}
