package practice.leetcode.ez;

public class ReverseString_II {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return "";
        }
        if (k == 1) {
            return s;
        }
        char[] cs = s.toCharArray();
        if (k > s.length()) {
            reverse(cs, 0, s.length() - 1);
            return new String(cs);
        }
        int i = 0;
        for (; i < s.length(); i += 2 * k) {
            reverse(cs, i, Math.min(i + k - 1, s.length() - 1));
        }
        // check value of i
        if (i < s.length()) {
            reverse(cs, i, Math.min(i + k - 1, s.length() - 1));
        }
        return new String(cs);
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }
}
