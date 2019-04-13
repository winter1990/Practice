package practice.leetcode.easy;

/**
 * @math
 * @search
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * linear is straightforward, 1 + 2 + 3 + ... + x < n
 *
 * (1 + x) * x / 2 <= n
 * find the largest x
 *
 * binary search
 * (1 + mid) * mid / 2 = n, return mid
 * > n, e = mid - 1
 * < n, s = mid + 1
 *
 * while look - not exact value, use end as result
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        long start = 1;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = (1 + mid) * mid / 2;
            if (val == n) {
                return (int) mid;
            } else if (val > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) end;
    }

    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(1804289383));
    }
}
