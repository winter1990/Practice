package practice.leetcode.medium;

/**
 * 1 1 1 1 1 1 1 1 1 1 1 1  removed    step 12 initially
 * 0 1 0 1 0 1 0 1 0 1 0 1, 1 3 5 7 9 11,2  6 left
 * 0 1 0 0 0 1 0 0 0 1 0 0, 12 8 4       4  3 left
 * 0 0 0 0 0 1 0 0 0 0 0 0, 2 10         8  1 left
 *
 * 0 1 0 1 0 1 0 1 0 1 0, 1 3 5 7 9 11, 2 4 6 8 10
 * 0 0 0 1 0 0 0 1 0 0 0, 2 6 10      , 4 8
 * 0 0 0 0 0 0 0 1 0 0 0, 4           , 8
 *
 * 1 2 3 4 5 6 7 8 9 10 11 12
 * for nth loop,step is 2^n
 * keep track of remaining number left
 * leftmost number is 1 2 2 6
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        int step = 1;
        int leftmost = 1;
        boolean startFromLeft = true;
        int remain = n;
        while (remain != 1) {
            if (startFromLeft || remain % 2 == 1) {
                leftmost += step;
            }
            remain /= 2;
            step *= 2;
            startFromLeft = !startFromLeft;
        }
        return leftmost;
    }
}
