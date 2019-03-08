package practice.leetcode.medium;

/**
 * @string
 * @pointer
 *
 * Given an input string, reverse the string word by word.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 *
 * method 1
 * tokenize the string with the separator " "
 * swap the strings using two pointer method
 *
 * method 2
 * if no util method is allowed to use, then reverse the whole string
 * "abc def" -> "fed cba" and reverser a single string "fed" and "cba"
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] cs = s.toCharArray();
        reverse(cs, 0, cs.length - 1);
        int i = 0, j = 0, n = cs.length;
        while (j < n) {
            while (j < n && cs[j] == ' ') {
                j++;
            }
            i = j;
            while (j < n && cs[j] != ' ') {
                j++;
            }
            reverse(cs, i, j - 1);
        }
        return cleanSpacesBetweenWords(cs);
    }

    private String cleanSpacesBetweenWords(char[] cs) {
        int i = 0, j = 0, n = cs.length;
        while (j < n) {
            while (j < n && cs[j] == ' ') j++;
            while (j < n && cs[j] != ' ') cs[i++] = cs[j++];
            while (j < n && cs[j] == ' ') j++;
            if (j < n) cs[i++] = ' ';
        }
        return new String(cs).substring(0, i);
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char tmp = cs[i];
            cs[i++] = cs[j];
            cs[j--] = tmp;
        }
    }

    public static String reverseWords1(String s) {
        StringBuilder res = new StringBuilder();
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ') continue;
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            res.append(s.substring(start + 1, end + 1)).append(" ");
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        String[] strs = s.split(" ");
        int i = 0;
        int j = strs.length - 1;
        while (i < j) {
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < strs.length; k++) {
            if (strs[k].length() != 0) {
                sb.append(strs[k]);
                sb.append(" ");
            }
        }
        return sb.toString().substring(0, sb.length());
    }

    public static void main(String[] args) {
        ReverseWordsInAString rw = new ReverseWordsInAString();
        System.out.println(rw.reverseWords("a good   example"));
        System.out.println(rw.reverseWords("hello world!  "));
        String s2 = "   a   b ";
        System.out.println(rw.reverseWords(s2));

    }
}
