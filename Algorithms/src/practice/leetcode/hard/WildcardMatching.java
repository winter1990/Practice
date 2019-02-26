package practice.leetcode.hard;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int s_cur = 0;
        int p_cur= 0;
        int match = 0;
        int star = -1;
        int sLen = s.length();
        int pLen = p.length();
        while (s_cur < sLen) {
            if (p_cur < pLen && (s.charAt(s_cur) == p.charAt(p_cur) || p.charAt(p_cur) == '?')) {
                s_cur++;
                p_cur++;
            } else if (p_cur < pLen && p.charAt(p_cur) == '*') {
                match = s_cur;
                star = p_cur;
                p_cur++;
            } else if (star != -1) {
                p_cur = star + 1;
                match = match + 1;
                s_cur = match;
            } else {
                return false;
            }
        }
        while (p_cur < pLen && p.charAt(p_cur) == '*') {
            p_cur = p_cur + 1;
        }
        if (p_cur == pLen) {
            return true;
        } else {
            return false;
        }
    }
}
