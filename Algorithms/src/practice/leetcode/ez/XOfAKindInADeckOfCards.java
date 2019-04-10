package practice.leetcode.ez;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more
 * groups of cards, where:
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 * count the frequency for each number in the array
 * the frequencies must have a common divisor which is >= 2
 * the problem becomes, find the greatest common divisor
 * [6 12] 6, [7 15] 0, [3 15] 3
 *
 * [6 12 15] expected 3
 * res = 0 [6 0] res = 6
 * res = 6 [12 6] [6 0] res = 6
 * res = 6 [6 15] [15 6] [6 3] [3 0] res = 3
 */
public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        for (int v : map.values()) res = gcd(v, res);
        return res >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
