package practice.leetcode.easy;

/**
 * @string
 *
 * XYZ -> (X-A+1)*26^2 + (Y-A+1)*26^1 + (Z-A+1)^26^0
 * start with last character, pow value from 0 to len - 1
 */

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(s.length() - 1 - i) - 'A' + 1) * Math.pow(26, i);
        }
        return res;
    }
}
