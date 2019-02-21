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
        String in = "   a   b ";
        System.out.println(rw.reverseWords(in));
    }
}
