package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        if (left > right) {
            return null;
        }
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j != 0; j /=10) {
                if (j % 10 == 0 || i % (j % 10) != 0) {
                    break;
                }
            }
            if (j == 0) {
                res.add(i);
            }
        }
        return res;
    }
}

