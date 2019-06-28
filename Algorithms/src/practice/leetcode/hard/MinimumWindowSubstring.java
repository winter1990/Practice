package practice.leetcode.hard;

/**
 * @slidingwindow
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * count the frequency of characters in target string
 * use two pointers to maintain the window / substring
 * keep extending the right bound and count the frequency of visited chars -> need a separate counter map/array
 * also need to count the number of characters found in the window -> found[c]<=toFind[c] count++
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int[] cs = new int[256], ct = new int[256];
        for (int i = 0; i < n; i++) ct[t.charAt(i)]++;
        int min = Integer.MAX_VALUE;
        String res = "";
        int count = 0;
        for (int i = 0, pre = 0; i < m; i++) {
            char c = s.charAt(i);
            if (ct[c] == 0) continue;
            cs[c]++;
            if (cs[c] <= ct[c]) count++;
            if (count == t.length()) {
                while (ct[s.charAt(pre)] == 0 || cs[s.charAt(pre)] > ct[s.charAt(pre)]) {
                    if (cs[s.charAt(pre)] > ct[s.charAt(pre)]) cs[s.charAt(pre)]--;
                    pre++;
                }
                if (i - pre + 1 < min) {
                    res = s.substring(pre, i + 1);
                    min = i - pre + 1;
                }
            }
        }
        return res;
    }

    public String minWindow1(String s, String t) {
        int[] ct = new int[256];
        int[] cs = new int[256];
        for (char c : t.toCharArray()) ct[c]++;
        int l = 0, r = 0, count = 0, min = Integer.MAX_VALUE;
        String res = "";
        for (;r < s.length(); r++) {
            char c = s.charAt(r);
            if (ct[c] != 0) {
                cs[c]++;
                if (cs[c] <= ct[c]) count++;
            }
            if (count == t.length()) {
                while (l < r) {
                    if (cs[s.charAt(l)] != 0) {
                        if (--cs[s.charAt(l)] < ct[s.charAt(l)]) {
                            count--;
                            break;
                        }
                    }
                    l++;
                }
                if (r - l + 1 < min) {
                    res = s.substring(l, r + 1);
                    min = r - l + 1;
                }
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow1(s, t));
    }
}
