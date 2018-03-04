package practice.leetcode.hard;

/**
 *
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = preprocess(tmp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private int[] preprocess(String s) {
        char[] cs = s.toCharArray();
        int[] next = new int[s.length()];
        int i = 0;
        int j = -1;
        next[i] = -1;

        while (i < s.length()) {
            if (j == -1 || cs[i] == cs[j]) {
                next[i] = j;
                i++;
                j++;

            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome(s));
    }
}
