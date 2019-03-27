package practice.leetcode.hard;

/**
 * @slidingwindow
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 *
 * count the frequency of characters in target string
 * use two pointers to maintain the window / substring
 * keep extending the right bound and count the frequency of visited chars -> need a separate counter map/array
 * also need to count the number of characters found in the window -> found[c]<=toFind[c] count++
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        for (int i = 0; i < tLen; i++) needToFind[t.charAt(i)]++;
        int minWindow = Integer.MAX_VALUE;
        String res = "";
        int count = 0;

        for (int start = 0, end = 0; end < sLen; end++) {
            if (needToFind[s.charAt(end)] == 0) continue;
            char c = s.charAt(end);
            hasFound[c]++;

            if(hasFound[c] <= needToFind[c]) count++;
            if (count == t.length()) {
                while (needToFind[s.charAt(start)] == 0 || hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
                    if (hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) hasFound[s.charAt(start)]--;
                    start++;
                }
                if (end - start + 1 < minWindow) {
                    minWindow = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
        }
        return res;
    }
}
