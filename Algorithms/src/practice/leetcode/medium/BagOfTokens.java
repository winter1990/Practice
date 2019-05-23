package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @greedy
 *
 * You have an initial power P, an initial score of 0 points, and a bag of tokens.
 * Each token can be used at most once, has a value token[i], and has potentially two ways to use it.
 *   If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
 *   If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
 * Return the largest number of points we can have after playing any number of tokens.
 *
 * greedy solution:
 * sort the tokens and define two pointers
 * greedily get points until no not enough power to redeem token
 * use one point to get most power and continue redeem the token
 */
public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int p) {
        if (tokens == null || tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int n = tokens.length, l = 0, r = n - 1, res = 0, cur = 0;
        while (l <= r) {
            while (l <= r && p >= tokens[l]) {
                p -= tokens[l++];
                cur++;
            }
            res = Math.max(res, cur);
            if (cur > 0 && r > l) {
                p += tokens[r--];
                cur--;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BagOfTokens b = new BagOfTokens();
        System.out.println(b.bagOfTokensScore(new int[]{100,200}, 150));
    }
}
