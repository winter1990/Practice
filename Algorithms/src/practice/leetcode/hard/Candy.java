package practice.leetcode.hard;

/**
 * @array
 * @greedy
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *   Each child must have at least one candy.
 *   Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * Input: [1,0,2] Output: 5
 * Input: [1,2,2] Output: 4
 *
 * for each element, if value is larger than either side, then it must have more candies
 * so each element is depends on left & right side [1 5 3 2 3 1 0]
 * scan from left to right, if inc +1 to left element, if dec 1
 * do the same from right to left
 * [1 5 3 2 3 1 0]
 *  1 2 1 1 2 1 1 ltr
 *  1 3 2 1 3 2 1 rtl
 *  1 3 2 1 3 2 1 max(ltr[i], rtl[i])
 *
 * [5 3 1 0 7 8]
 *  1 1 1 1 2 3
 *  4 3 2 1 1 1 -> 4 3 2 1 2 3
 *
 * [1 2 3 3 1]
 *  1 2 3 1 1
 *  1 1 1 2 1 -> 1 2 3 2 1
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        int n = ratings.length;
        int[] lr = new int[n], rl = new int[n];
        lr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] >= ratings[i]) {
                lr[i] = 1;
            } else {
                lr[i] = lr[i - 1] + 1;
            }
        }
        rl[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] <= ratings[i + 1]) {
                rl[i] = 1;
            } else {
                rl[i] = rl[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) sum += Math.max(lr[i], rl[i]);
        return sum;
    }
}
