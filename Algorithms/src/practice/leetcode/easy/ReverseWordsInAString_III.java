package practice.leetcode.easy;

/**
 * @string
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 *
 * Input:  "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInAString_III {
    public String reverseWords(String s) {
        int i = 0, j = 0, n = s.length();
        char[] cs = s.toCharArray();
        while (j < n) {
            while (j < n && cs[j] != ' ') {
                j++;
            }
            reverse(cs, i, j - 1);
            i = j + 1;
            j = i;
        }
        return new String(cs);
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString_III re = new ReverseWordsInAString_III();
        String s = "Let's take LeetCode contest";
        System.out.println(re.reverseWords(s));
        System.out.println("s'teL ekat edoCteeL tsetnoc");
    }
}
