package practice.leetcode.hard;

/**
 * @dp
 * @heap
 *
 * Your car starts at position 0 and speed +1 on an infinite number line
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 ,
 * otherwise speed = 1.  (Your position stays the same)
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 *
 * position += speed, speed *= 2
 * [0 1] [pos, speed], AAR -> [1 2] -> [3 4] -> [3 -1]
 *
 * target can be positive or negative
 * target = 3, Output: 2 AA
 * target = 6, Output: 5 AAARA [0 1] [1 2] [3 4] [7 8] [7 -1] [6 -2]
 *
 * if we keep going to right: 0 1 3 7 15... (2^n - 1)
 * target = 5, [0 1] - [1 2] [3 4] R [2 -1] R [3 2] [5 4] = 7 steps
 * for positive: 1 2 4 8 16... so the location would be 1 3 7 15 31...
 *
 * if we go to i:
 * if i = 2^n - 1, then n is the optimal steps
 * if 2^(n-1) - 1 < i < 2^n - 1, there are two ways to go to i
 *   1. pass the i, and turn around -> n + 1 steps. remaining dp[2^n - i]
 *   2. stop before arriving i, 2^(n-1)-1 change direction, and get the min
 */
public class RaceCar {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            int dis = (Integer.highestOneBit(i) << 1) - 1;
            int n = Integer.bitCount(dis);
            // no need to reverse
            if (dis == i) {
                dp[i] = n;
                continue;
            }
            // one step after i
            dp[i] = dp[dis - i] + n + 1;
            // one step before i
            dis >>= 1;
            for (int j = 0; j < n; j++) {
                int diff = (1 << j) - 1;
                dp[i] = Math.min(dp[i], dp[i - dis + diff] + n + j + 1);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        RaceCar r = new RaceCar();
        System.out.println(r.racecar(5));
    }
}
