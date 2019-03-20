package practice.leetcode.medium;

/**
 * @string
 *
 * we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same
 * character c to it so that the length of the group is 3 or more
 * Input: S = "heeellooo", words = ["hello", "hi", "helo"], Output: 1
 *
 * two pointers
 * for each word, compare the word with string
 * heeellooo
 * he  llo
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String w : words) if (isExpressive(S, w)) count++;
        return count;
    }

    private boolean isExpressive(String s, String w) {
        int m = s.length(), n = w.length();
        if (m < n) return false;
        int i = 0, j = 0;
        for (; i < m; i++) {
            if (j < n && s.charAt(i) == w.charAt(j)) j++;
            else if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2));
            else if (i > 0 && i < m - 1 && s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == s.charAt(i + 1));
            else return false;
        }
        return j == n;
    }

    public static void main(String[] args) {
        String[] in = {"hi", "helo", "hello"};
        String s = "heeellooo";
        ExpressiveWords ew = new ExpressiveWords();
        System.out.println(ew.expressiveWords(s, in));
    }
}
