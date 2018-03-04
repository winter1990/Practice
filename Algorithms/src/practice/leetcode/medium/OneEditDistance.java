package practice.leetcode.medium;

/**
 * compare the length
 * if l1-l1=1,delete and insert
 * if l1-l2=0,replace
 *
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        } else if (s.length() == 0 && t.length() == 0) {
            return false;
        } else if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            return replaceCheck(s, t);
        }
        if (s.length() > t.length()) { // shorter at first
            return insertDeleteCheck(t, s);
        } else {
            return insertDeleteCheck(s, t);
        }
    }

    private boolean insertDeleteCheck(String s1, String s2) {
        int index = 0;
        while (index < s1.length()) {
            if (s1.charAt(index) != s2.charAt(index)) {
                return s1.substring(index).equals(s2.substring(index + 1));
            }
            index++;
        }
        return true;
    }

    private boolean replaceCheck(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneEditDistance oe = new OneEditDistance();
        String s1 = "cab";
        String s2 = "ad";
        System.out.println(oe.isOneEditDistance(s1, s2));
    }
}
