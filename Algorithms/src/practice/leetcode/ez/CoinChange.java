package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * @@dp
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * dp
 * create a dp array with size amount+1, start from 1
 * dp[i] represents minimum ways to reach amount of i
 * if not possible -> dp[i] = -1
 * transition function:
 * for each coin
 *  if value of coin <= i && dp[i - coin] != -1
 *    use a variable min to keep track all the current minimum values
 *    get minimum -> min(dp[i - coin], min)
 *  dp[i] = min or -1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) min = dp[i - coin] < min ? dp[i - coin] : min;
            }
            // Set dp[i] to -1 if i (current amount) can not be reach by  coins array
            dp[i] = min == Integer.MAX_VALUE ? -1 : 1 + min;
        }
        return dp[amount];
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int count = amount + 1;
        for (int coin : coins) {
            int cur = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);
                if (next >= 0) {
                    cur = next + 1;
                }
            }
            if (cur > 0) {
                count = Math.min(count, cur);
            }
        }
        int finalCount = count == amount + 1 ? -1 : count;
        map.put(amount, finalCount);
        return finalCount;
    }

    // tle as well
    /*
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int n = amount + 1;
        for (int c : coins) {
            int cur = 0;
            if (amount >= c) {
                int next = coinChange(coins, amount - c);
                if (next >= 0) {
                    cur = 1 + next;
                }
            }
            if (cur > 0) {
                n = Math.min(n, cur);
            }
        }
        return n == amount + 1 ? -1 : n;
    }

    /*
    // keep going from largest to smallest will not work
    // [186,419,83,408]
    // 6249
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        helper(coins, 0, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void helper(int[] coins, int num, int amount) {
        if (amount == 0) {
            min = Math.min(min, num);
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            helper(coins, num + 1, amount - coins[i]);
            if (min != Integer.MAX_VALUE) {
                return;
            }
        }
    }
    */
    public static void main(String[] args) {
        int[] in = {186,419,83,408};
        CoinChange cc = new CoinChange();
        int val = 6249;
        System.out.println(cc.coinChange(in, val));
    }
}
