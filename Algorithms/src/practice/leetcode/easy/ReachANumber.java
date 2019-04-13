package practice.leetcode.easy;

/**
 * @math
 *
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 * Return the minimum number of steps required to reach the destination.
 * target will be a non-zero integer
 *
 * + or - does not matter because symmetric, so focus on positive integer only
 * for any integer problem, think about odd and even, naturally
 * two options: left or right
 * if go right only, we will exceed to target at some point, so we need to choose some number between to go left
 * if go left, the change of sum will be i*2. so we need to make the difference even number
 * target = 5, 1 + 2 + 3 = 6, 1 step difference -> odd
 *
 * if diff is odd, need to keep going
 * if diff is even, we can go back for current step
 */
public class ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
