package practice.leetcode.medium;

/*
Given n = 3.

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].
 */

/**
 * initialize int[n+1]
 * brute force
 *
 * math
 * 12,1 12 2 6 3 4 all values in pair
 * only the value with int square root
 * i will end up on if i is a square
 */
public class BulbSwitcher {
    public int bulbSwitch3(int n) {
        return (int)Math.sqrt(n);
    }

    // time limit exceeded 9999999
    public int bulbSwitch2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                res[j] = res[j] == 0 ? 1 : 0;
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i] == 1) result++;
        }
        return result;
    }

    // time efficiency
    public int bulbSwitch1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) res[j] = res[j] == 0 ? 1 : 0;
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i] == 1) result++;
        }
        return result;
    }
}
