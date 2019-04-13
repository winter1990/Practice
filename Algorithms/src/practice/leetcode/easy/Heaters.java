package practice.leetcode.easy;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index = 0;
        int res = 0;
        for (int house : houses) {
            while (index < heaters.length - 1 && heaters[index] + heaters[index + 1] <= house * 2) {
                index++;
            }
            res = Math.max(res, Math.abs(heaters[index] - house));
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
