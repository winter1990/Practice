package practice.leetcode.ez;

import java.util.Arrays;
import java.util.List;

/*
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        if (words.get(0).length() != n) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (words.get(i).length() > words.get(i - 1).length()) {
                return false;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j + i < n; j++) {
                char c1 = i + j >= words.get(i).length() ? ' ' : words.get(i).charAt(i + j);
                char c2 = i >= words.get(i + j).length() ? ' ' : words.get(i + j).charAt(i);
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] s = {"abcd", "bnrt", "crm", "dt"};
        List<String> s = Arrays.asList("abc",
                                       "bde",
                                       "cefggggg");
        ValidWordSquare v = new ValidWordSquare();
        System.out.println(v.validWordSquare(s));
    }
}
