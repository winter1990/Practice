package practice.leetcode.easy;

public class ReverseWordsInAString_III {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        int i = 0, j = i;
        while (i < cs.length) {
            while (i < cs.length && cs[i] == ' ') {
                i++;
            }
            j = i;
            while (j < cs.length - 1 && cs[j + 1] != ' ') {
                j++;
            }
            reverse(cs, i, j);
            i = j + 1;
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
