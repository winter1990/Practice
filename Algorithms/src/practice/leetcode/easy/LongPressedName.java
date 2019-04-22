package practice.leetcode.easy;

/**
 * @string
 *
 * Input: name = "alex", typed = "aaleex", Output: true
 * Input: name = "saeed", typed = "ssaaedd", Output: false
 * Input: name = "leelee", typed = "lleeelee", Output: true
 * Input: name = "laiden", typed = "laiden", Output: true
 *
 * two pointers
 * i traverse name, j traverse typed
 * two cases:
 *   exact match, j++
 *   not match
 *
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        int i = 0, j = 0;
        for (; i < name.length(); i++) {
            if (i != 0 && name.charAt(i) != name.charAt(i - 1)) {
                while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) j++;
            }
            if (j < typed.length() && name.charAt(i) != typed.charAt(j)) {
                return false;
            } else {
                j++;
            }
        }
        while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) j++;
        return j == typed.length();
    }

    public boolean isLongPressedName1(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j) {
            if (i < m && name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
        }
        return i == m;
    }

    public static void main(String[] args) {
        LongPressedName l = new LongPressedName();
        String s = "a";
        String t = "aa";
        System.out.println(l.isLongPressedName(s, t));
    }
}
