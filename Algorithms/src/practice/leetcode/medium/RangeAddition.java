package practice.leetcode.medium;

/**
 *
 */
public class RangeAddition {
    public int[] getModifiedArray1(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int s = update[0];
            int e = update[1];
            int v = update[2];
            res[s] += v;
            if (e < length - 1) res[e + 1] -= v;
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
