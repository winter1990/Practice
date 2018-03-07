package practice.leetcode.medium;

public class CustomSortString {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return T;
        }
        String res = T;
        int index;
        int offset = 0;
        for (int i = 0; i < S.length(); i++) {
            while (true) {
                index = res.substring(offset).indexOf(S.charAt(i));
                if (index == -1) break;
                res = res.substring(0, offset) + S.charAt(i)
                        + res.substring(offset, offset + index) + res.substring(offset + index + 1);
                offset++;
            }
        }
        return res;
    }

    // map or array to store the freq of each character
    public String customSortString1(String S, String T) {
        int[] freq = new int[26];
        for (char c : T.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (freq[c - 'a']-- > 0)
                sb.append(c);
        }
        for (char c : T.toCharArray()) {
            if (freq[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cba";
        String t = "abcd";
        CustomSortString css = new CustomSortString();
        System.out.println(css.customSortString1(s,t));
    }
}
