package practice.leetcode.hard;

public class Candy {
    public int candy(int[] ratings) {
        // 1. what conditions will decide the number of candies: increasing order of array,
        //    example: [1,5,4,3,2,1] from left to right not enough, also consider right to left
        // 2. at least one, who will get the least: arr[i] which left and right are both bigger
        // scan once get the number of elements who get the only 1 candy
        // scan from left to right and right to left, add 1
        // scan again get max

        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int n = ratings.length;
        int[] lr = new int[n];
        int[] rl = new int[n];

        lr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] <= ratings[i - 1]) {
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
        for (int i = 0; i < n; i++) {
            sum += Math.max(lr[i], rl[i]);
        }
        return sum;
    }
}
