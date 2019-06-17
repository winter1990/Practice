package practice.leetcode.medium;

/**
 * @string
 *
 * we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same
 * character c to it so that the length of the group is 3 or more
 * Input: S = "heeellooo", words = ["hello", "hi", "helo"], Output: 1
 *
 * heeellooo
 * he  llo -> true
 *
 * heeeelllo
 * he   ll o -> true
 * as long as a group of character can be extended to size of 3 or more, then it counts
 *
 * check whether S is expressive compared to w in the list
 * i -> S, j -> word
 * cases:
 *   if s[i] = w[j], j++
 *   else if 0<i<n-1 and s[i-1] s[i] s[i+1] the same, i++
 *   !(i > 1 and s[i-2] = s[i-1] = s[i]) false
 * check if i and j both reach end
 *
 */
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String w : words) {
            int i, j; //i for S, j for word
            for (i = 0, j = 0; i < s.length(); i++) {
                if (j < w.length() && s.charAt(i) == w.charAt(j)) {
                    j++;
                } else if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                } else if (i > 0 && i < s.length() - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1)) {
                } else {
                    break;
                }
            }
            if (i == s.length() && j == w.length()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] in = {"hi", "helo", "hello","heello"};
        String s = "heeellooo";
//        String s = "heeello";
//        String[] in = {"heello"};
        ExpressiveWords ew = new ExpressiveWords();
        System.out.println(ew.expressiveWords(s, in));
    }
}
