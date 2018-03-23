package practice.leetcode.ez;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * total number of bits, at most 31
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
        int res = 0;
        for (int i = L; i <= R; i++) {
            int bits = 0;
            for (int number = i; number > 0; number >>= 1) {
                if ((number & 1) == 1) {
                    bits++;
                }
            }
            if (set.contains(bits)) {
                res++;
            }
        }
        return res;
    }
}
