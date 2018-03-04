package practice.leetcode.ez;

/**
 * "hello world" => 5
 * A word is defined as a character sequence consists of non-space characters only.
 *
 * trim(), then count
 * conditions:
 * - empty&nonempty
 * - count == 0?
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int c = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ' && c == 0) { // trim
                i--;
            } else if (s.charAt(i) != ' ') {
                i--;
                c++;
            } else {
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String s1 = "    ";
        String s2 = "abc aaa";
        String s3 = "abcd    ";
        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
        System.out.println(lengthOfLastWord(s3));
    }
}
