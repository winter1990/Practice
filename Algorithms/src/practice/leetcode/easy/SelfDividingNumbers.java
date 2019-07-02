package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @math
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) res.add(i);
        }
        return res;
    }

    private boolean isValid(int n) {
        int m = n;
        while (m > 0) {
            if (m % 10 == 0 || n % (m % 10) != 0) return false;
            m /= 10;
        }
        return true;
    }
}

