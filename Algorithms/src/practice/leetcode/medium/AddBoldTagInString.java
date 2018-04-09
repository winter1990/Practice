package practice.leetcode.medium;

/**
 * s = "abcxyz123", dict = ["abc","123"] Output: "<b>abc</b>xyz<b>123</b>"
 * s = "aaabbcc" dict = ["aaa","aab","bc"] Output: "<b>aaabbc</b>c"
 *
 * merge strings
 */
public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[] checker = new boolean[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (String str : dict) {
                if (s.startsWith(str, i)) {
                    end = Math.max(end, i + str.length());
                }
            }
            checker[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!checker[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < n && checker[j]) {
                j++;
            }
            sb.append("<b>").append(s.substring(i, j)).append("</b>");
            i = j - 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] dict = //{"a", "c", "e", "g"};
                {"a", "b", "c"};
                //{"aaa","ab","c"};
        String s = "abcdef";
                //"aaabbcc";
        AddBoldTagInString ad = new AddBoldTagInString();
        System.out.println(ad.addBoldTag(s, dict));
    }
}
