package practice.leetcode.easy;

/**
 * @string
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * 1%26 = A + (1 - 1) = A
 * 26     A + (26 - 1) = Z
 * 27/26 = 1 27 % 26 = 1 A + (1 - 0) = A
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n -= 1;
            char c = (char) ('A' + n % 26);
            sb.insert(0, c);
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle es = new ExcelSheetColumnTitle();
        System.out.println(es.convertToTitle(27));
    }
}
