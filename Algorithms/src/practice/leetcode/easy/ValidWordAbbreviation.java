package practice.leetcode.easy;

/*
"internationalization"
"i12iz4n"
true
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if ((word == null && abbr == null) || (word.length() == 0 && abbr.length() == 0)) {
            return true;
        }
        int index1 = 0;
        int index2 = 0;
        int m = word.length();
        int n = abbr.length();
        int count = 0;
        while (index1 < m && index2 < n) {
            char c2 = abbr.charAt(index2);
            if (Character.isDigit(c2)) {
                if (count == 0 && (c2 - '0' == 0)) return false;
                count *= 10;
                count += c2 - '0';
                if (count > m) return false;
                if (index2 == n - 1 || !Character.isDigit(abbr.charAt(index2 + 1))) {
                    while (count > 0) {
                        index1++;
                        count--;
                    }
                }
                index2++;
            } else if (Character.isLetter(c2)) {
                if (c2 != word.charAt(index1)) {
                    return false;
                } else {
                    index1++;
                    index2++;
                }
            }
        }
        return index1 == m && index2 == n;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation v = new ValidWordAbbreviation();
        String s = "bignumberhahaha";
        String t = "999999999";
        System.out.println(v.validWordAbbreviation(s,t));
    }
}
