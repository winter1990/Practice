package practice.leetcode.easy;

/**
 * get substring from 0 index with length 0 1 2 ... len/2
 * walk through and compare
 *
 * two indice:
 * - i get substring
 * - j start with i
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            String t = s.substring(0, i);
            if (s.length() % t.length() != 0) {
                continue;
            }
            for (int j = i; j <= s.length() - t.length(); j += t.length()) {
                if (j == s.length() - t.length() && s.substring(j, j + t.length()).equals(t)) {
                    return true;
                } else if (!s.substring(j, j + t.length()).equals(t)) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcabc";
        String s2 = "abc";
        String s3 = "aaaaa";
        String s4 = "aba";
        RepeatedSubstringPattern a = new RepeatedSubstringPattern();
        System.out.println(a.repeatedSubstringPattern(s1));
        System.out.println(a.repeatedSubstringPattern(s2));
        System.out.println(a.repeatedSubstringPattern(s3));
        System.out.println(a.repeatedSubstringPattern(s4));
    }
}
