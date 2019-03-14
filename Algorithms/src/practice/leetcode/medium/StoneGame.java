package practice.leetcode.medium;

/**
 * @dp
 * @math
 *
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 *
 * 0 1 2 3 4 5
 * alex can always pick either odd or even index of stones
 * sum of stones is odd, so sum(a[0] a[2] a[4]...a[n-2]) != sum(a[1] a[3] a[5]...a[n-1]) are different
 * so alex is controlling the to choose which ever array of stones he wants -> odd or even
 * so alex wins 100% with optimistic strategy
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
