package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @math
 *
 * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
 * Input: x = 2, y = 3, bound = 10, Output: [2,3,4,5,7,9,10]
 * Input: x = 3, y = 5, bound = 15, Output: [2,4,6,8,10,14]
 *
 * x^i + y^j <= bound
 * use a set to remove duplicates
 * i = 1, i < bound, i *= x
 *   j = 1, j + i <= bound, j *= y
 *     add to result set
 *
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
