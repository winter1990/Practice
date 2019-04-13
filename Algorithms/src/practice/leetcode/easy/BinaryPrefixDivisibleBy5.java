package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @math
 * @array
 *
 * if the number of divisible by 5:
 *   0 5 10 15...
 *   0 101 1010 0111
 *   the last digit of the number must be ending with 0 or 5
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int v = 0;
        for (int a : A) {
            v = ((v << 1) + a) % 5;
            res.add(v == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0,1,1};
        BinaryPrefixDivisibleBy5 b = new BinaryPrefixDivisibleBy5();
        System.out.println(b.prefixesDivBy5(a));
    }
}
