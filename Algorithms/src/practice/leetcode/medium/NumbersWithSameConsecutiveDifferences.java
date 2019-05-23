package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @dp
 *
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive
 * digits is K.
 * Note that every number in the answer must not have leading zeros except for the number 0 itself.
 *
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 *
 * initial [0,1,...,9]
 * [70 81 92 07 81 92]
 * [070 181 292 707 181 292]
 */
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        for (int i = 2; i <= N; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int x : list) {
                int y = x % 10;
                if (x != 0 && y + K <= 9) tmp.add(x * 10 + y + K);
                if (x != 0 && K != 0 && y - K >= 0) tmp.add(x * 10 + y - K);
            }
            list = tmp;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences n = new NumbersWithSameConsecutiveDifferences();
        n.numsSameConsecDiff(2,0);
    }
}
