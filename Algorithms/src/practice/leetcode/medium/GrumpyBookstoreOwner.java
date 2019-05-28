package practice.leetcode.medium;

/**
 * @array
 *
 * customers = [1,0,1,2,1,1,7,5]
 *    grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16
 *
 * translation:
 * window size is 3 and maximize sum of customers[i]*grumpy[i], where i is in range of X
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0, cur = 0, max = 0;
        for (int i = 0; i < customers.length; i++) {
            satisfied += grumpy[i] == 0 ? customers[i] : 0;
            cur += customers[i] * grumpy[i];
            if (i >= X) cur -= customers[i - X] * grumpy[i - X];
            max = Math.max(max, cur);
        }
        return satisfied + max;
    }
}
