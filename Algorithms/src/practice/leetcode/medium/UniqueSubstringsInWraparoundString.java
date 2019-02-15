package practice.leetcode.medium;

/**
 * @string
 * @substring
 * @dp
 */
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] counter = new int[26];
        int maxLen = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            int index = p.charAt(i) - 'a';
            counter[index] = Math.max(maxLen, counter[index]);
        }

        int res = 0;
        for (int num : counter) {
            res += num;
        }
        return res;
    }
}
