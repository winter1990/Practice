package practice.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * the order of the chars in each string should remain the same
 * s1 = AB, s2 = CD
 * ABCD ACBD ACDB CADB CABD CDAB
 *
 * define two index = 0 -> the start index for the string
 * s1 - i1 = 0
 * s2 - i2 = 0
 * recursively addd char at i1 or i2
 * base condition - both index = string length
 * add to result list
 *
 */
public class CombinationOfTwoStrings {
    public List<String> getCombination(String s1, String s2) {
        List<String> res = new ArrayList<>();
        getCombo(s1, s2, 0, 0, "", res);
        return res;
    }

    private void getCombo(String s1, String s2, int i1, int i2, String s, List<String> res) {
        if (s.length() == (s1.length() + s2.length())) {
            res.add(s);
            return;
        }
        while (i1 < s1.length() || i2 < s2.length()) {
            if (i1 < s1.length()) getCombo(s1, s2 , i1 + 1, i2, s + s1.charAt(i1), res);
            if (i2 < s2.length()) getCombo(s1, s2 , i1, i2 + 1, s + s2.charAt(i2), res);
            i1++;
            i2++;
        }
    }

    public static void main(String[] args) {
        CombinationOfTwoStrings com = new CombinationOfTwoStrings();
        String s1 = "AB", s2 = "CDE";
        System.out.println(com.getCombination(s1, s2));
    }
}
