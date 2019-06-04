package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all
 * houses could be covered by those heaters.
 *
 * [1,2,3,4],[1,4], Output: 1
 * [1 3 5 9 10], [2 5 10 11], output: 1
 *                1 0  1  0
 *
 * problem to solve:
 * 1. which heater to choose to warm the house
 * 2. handle the redundant heaters (head, in the middle, tail) [3 4 5] [1 2 3 4 5 7 8]
 * 3. if house not in the middle of two heaters
 *
 * sort two arrays
 * for each house, to find the heater(s), it should be the closest one
 *   find closest on left and right
 *     h[i]+h[i+1] < house*2, right heater
 *     h[i]+h[i+1] = house*2, either left/right
 *     h[i]+h[i+1] > house*2, left heater
 *     if h[i]+h[i+1] <= house * 2, we continue the next pair of heaters
 *     then the distance is: [4] [1 5], 1+5<4*2, index++ = 1 (5), 5-4=1
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0, i = 0;
        for (int h : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= h * 2) i++;
            res = Math.max(res, Math.abs(heaters[i] - h));
        }
        return res;
    }

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
