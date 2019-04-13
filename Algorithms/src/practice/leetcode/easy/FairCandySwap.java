package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @array
 * @math
 *
 * hey would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 *
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int ta = 0, tb = 0;
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int a : A) {
            ta += a;
            set1.add(a);
        }
        for (int b : B) {
            tb += b;
            set2.add(b);
        }
        int[] res = new int[2];
        int diff = (tb - ta) / 2;
        for (int a : A) {
            if (set2.contains(a + diff)) {
                res[0] = a;
                res[1] = a + diff;
                break;
            }
        }
        return res;
    }
}
