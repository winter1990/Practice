package practice.leetcode.medium;

/**
 * @string
 * @slidingwindow
 *
 * s = "ABAB", k = 2 -> 4, replace 2 A with B or vice versa
 * s = "AABABBA", k = 1 -> 4, replace A in the middle, so BBBB is the longest
 *
 * within a window, we need to find the longest substring that has the hightest frequency of a char
 * and k chars that are not
 * then start sliding the window, keep track of the max freq and max length
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxLen = 0, maxFreq = 0, last = 0;
        for (int i = 0; i < s.length(); i++) {
            maxFreq = Math.max(++freq[s.charAt(i) - 'A'], maxFreq);
            if (i - last + 1 - maxFreq > k) {
                freq[s.charAt(last) - 'A']--;
                last++;
            }
            maxLen = Math.max(maxLen, i - last + 1);
        }
        return maxLen;
    }
}
