package practice.leetcode.ez;

import java.util.HashSet;
import java.util.Set;

/**
 * @math
 *
 * Input: 19, Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * our target: sum of all power of digits = 1, so 1^1 repeats itself
 * we need to keep track of the numbers we have calculated in order not to get into a 'circle'
 * check duplicate, hash ds -> map, hashset
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (n != 0) {
            if (n == 1){
                return true;
            }
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            sum = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber hm = new HappyNumber();
        System.out.println(hm.isHappy(3));
    }
}
