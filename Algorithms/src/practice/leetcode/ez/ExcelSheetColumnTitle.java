package practice.leetcode.ez;

/**
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * 1%26=1 A+(1-1)=A
 * 3%26=3 A+(3-1)=C
 * 26     A+25=Z
 * 27/26=1 A+0=A 27%26
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n -= 0;
            char c = (char)('A' + n % 26);
            sb.insert(0, c);
            n /= 26;
        }
        return sb.toString();
    }
}
