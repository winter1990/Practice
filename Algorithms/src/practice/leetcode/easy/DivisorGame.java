package practice.leetcode.easy;

/**
 * @math
 *
 * if we can make the N = 2, and Alice starts, then Alice will win for sure
 * if odd, pick some number and this number must be odd, because odd % even != even, N - picked number = even
 * if even, Alice pick 1, then it's odd, opponent pick an odd, N = even, until N = 2, then pick 1, win
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
