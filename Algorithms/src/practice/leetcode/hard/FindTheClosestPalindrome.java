package practice.leetcode.hard;

/**
 * @string
 *
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * The 'closest' is defined as absolute difference minimized between two integers.
 * The input n is a positive integer represented by string, whose length will not exceed 18.
 * If there is a tie, return the smaller one as answer
 *
 * palindrome definition - symmetric structure
 * input    output
 * 100      99      number of digits might be different
 * 100      101     101 is true but should return 99 as it's smaller
 * 198      202
 * 156      151/161 return 151
 * 256      252 (4 diff), 262 (6 diff)
 * 257      252/262 (5 diff) and we choose smaller
 * 10004    10001
 * how about 4 digits:
 * 1234     1221 -> the same logic with 3 digits
 * 1225     1221
 * 7221     7227
 * 1339     1331
 *
 * considering about the middle 3 digits, if the first digit and third one difference is less or equal than 5
 * then we find the smaller number
 * if difference is larger than 5, then we find the larger one
 *
 * 32123
 * 321123
 * 2002 1991
 *
 */
public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        if (n == null || n.length() == 0) {
            return "";
        }
        long val = Long.valueOf(n);
        // single digit
        if (val < 10) {
            return String.valueOf(val - 1);
        }
        // number of digits will decrease
        if ((n.charAt(0) == '1') && Long.valueOf(n.substring(1)) == 0) {
            return String.valueOf(val - 1);
        }
        // number of digits will increase
        while (val != 0) {
            if (val % 10 != 9) {
                break;
            }
            val /= 10;
        }
        if (val == 0) {
            return String.valueOf(Long.valueOf(n) + 2);
        }

        int len = n.length();
        int i1 = len / 2 - 1;
        int i2 = len % 2 == 0 ? len / 2 : len / 2 + 1;
        while (n.charAt(i1) == n.charAt(i2)) {
            i1--;
            i2++;
            if (i1 < 0) {
                break;
            }
        }
        // palindrome already
        if (i1 < 0) {
            if (Long.valueOf(n) == 11 || (n.charAt(0) == '1' && Long.valueOf(n.substring(1, len - 1)) == 0)) {
                return String.valueOf(Long.valueOf(n) - 2);
            } else {

            }
        }
        if (Math.abs(i1 - i2) > 2) {
            return n.substring(0, i2) + n.charAt(i1) + n.substring(i2 + 1);
        }
        StringBuilder sb = new StringBuilder(n.substring(0, i1));
        return n.substring(0, i1) + getClosest(n.substring(i1, i2 + 1)) + sb.reverse().toString();
    }

    private String getClosest(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (Math.abs(cs[0] - cs[n - 1]) <= 5) {
            if (cs.length % 2 == 0) {
                cs[1] = cs[0];
            } else {
                cs[2] = cs[0];
            }
        } else {
            if (cs.length % 2 == 1) {
                if (cs[0] > cs[2]) { //921 919, 129 232
                    cs[2] = cs[0];
                    cs[1] += 1;
                } else {
                    cs[2] = cs[0];
                }
            } else {
                if (cs[0] > cs[1]) {
                    cs[0]--;
                    cs[1] = cs[0];
                } else {
                    cs[0]++;
                    cs[1] = cs[0];
                }
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        FindTheClosestPalindrome f = new FindTheClosestPalindrome();
        System.out.println(f.nearestPalindromic("202"));
    }
}
