package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @string
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * 69 88 1 818 => 1 8 6...9
 * 69 in pair, 0, 1, 8
 * scan through string, check symmetric char
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        for (int i = 0; i <= num.length() / 2; i++) {
            if (!map.containsKey(num.charAt(i))) {
                return false;
            }
            if (map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrobogrammatic1(String num) {
        String s = "00 11 88 696";
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!s.contains(num.charAt(i) + "" + num.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
