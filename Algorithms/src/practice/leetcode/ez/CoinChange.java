package practice.leetcode.ez;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
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
