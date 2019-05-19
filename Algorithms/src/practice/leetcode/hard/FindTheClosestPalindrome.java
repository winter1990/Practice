package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if (n == null || n.length() == 0) return "";
        long val = Long.valueOf(n);
        if (val < 10) return String.valueOf(val - 1);
        if ((n.charAt(0) == '1') && Long.valueOf(n.substring(1)) == 0) return String.valueOf(val - 1);
        int len = n.length(), halfLength = (len + 1) / 2;
        long half = Long.valueOf(n.substring(0, halfLength));

        List<Long> candidates = new ArrayList<>();
        candidates.add(allNine(len - 1));
        candidates.add(getOneZeroOne(len + 1));

        getCandidates(candidates, half, len);
        long diff = Long.MAX_VALUE;
        String res = "";
        Collections.sort(candidates);
        for (long l : candidates) {
            if (l == val) continue;
            if (Math.abs(l - val) < diff) {
                diff = Math.abs(l - val);
                res = String.valueOf(l);
            }
        }
        return res;
    }

    private void getCandidates(List<Long> candidates, long half, int len) {
        List<Long> list = new ArrayList<>();
        list.add(half);
        list.add(half + 1);
        list.add(half - 1);
        for (long l : list) {
            if (len % 2 == 0) {
                String s = String.valueOf(l);
                s += new StringBuilder(s).reverse().toString();
                candidates.add(Long.valueOf(s));
            } else {
                String s = String.valueOf(l);
                s += new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
                candidates.add(Long.valueOf(s));
            }
        }
    }

    private Long allNine(int len) {
        long res = 0;
        for (int i = 1; i <= len; i++) {
            res *= 10;
            res += 9;
        }
        return res;
    }

    private Long getOneZeroOne(int len) {
        return (long) Math.pow(10, len - 1) + 1;
    }

    public static void main(String[] args) {
        FindTheClosestPalindrome f = new FindTheClosestPalindrome();
        System.out.println(f.nearestPalindromic("997"));
    }
}
