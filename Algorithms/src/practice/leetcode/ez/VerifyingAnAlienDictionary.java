package practice.leetcode.ez;

/**
 * @string
 * @hash
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz", Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 *
 * abc...xyz, int[26] arr[0] -> 'a', arr[1] -> [b],... the mapping relation between index and character
 * order is 'reordered' we can still use a arr with the size 26, for each char in order,
 * assign the value which means new order
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < 26; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], dict) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String s1, String s2, int[] dict) {
        int i = 0;
        while (i < Math.min(s1.length(), s2.length())) {
            if (dict[s1.charAt(i) - 'a'] > dict[s2.charAt(i) - 'a']) {
                return 1;
            } else if (dict[s1.charAt(i) - 'a'] < dict[s2.charAt(i) - 'a']) {
                return -1;
            }
            i++;
        }
        return i == s1.length() ? -1 : 1;
    }
}
