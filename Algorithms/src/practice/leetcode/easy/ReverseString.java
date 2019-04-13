package practice.leetcode.easy;

public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] cs = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(cs);
    }

    /**
     * divide and conquer
     */

    public String reverseString1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        String l = s.substring(0, len / 2);
        String r = s.substring(len / 2, len);
        return reverseString1(r) + reverseString1(l);
    }
}
