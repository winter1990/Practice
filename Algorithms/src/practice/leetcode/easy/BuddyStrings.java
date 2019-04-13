package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @string
 *
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters
 * in A so that the result equals B.
 * Input: A = "ab", B = "ba", Output: true
 * Input: A = "ab", B = "ab", Output: false
 * Input: A = "aa", B = "aa", Output: true
 * Input: A = "aaaaaaabc", B = "aaaaaaacb", Output: true
 *
 * if two strings are the same, there must be some char appears twice
 * if two strings are not same, exactly two chars different and swap
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        } else if (A.length() < 2) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        boolean hasDuplicate = false;
        Integer diff1 = null;
        Integer diff2 = null;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (diff1 == null) {
                    diff1 = i;
                } else if (diff2 == null) {
                    diff2 = i;
                    break;
                }
            }
            if (!set.add(A.charAt(i))) {
                hasDuplicate = true;
            }
        }
        if (A.equals(B) && hasDuplicate) {
            return true;
        }
        if (diff1 != null && diff2 != null && A.charAt(diff1) == B.charAt(diff2) && A.charAt(diff2) == B.charAt(diff1)) {
            char[] swappedString = B.toCharArray();
            char tmp = swappedString[diff1];
            swappedString[diff1] = swappedString[diff2];
            swappedString[diff2] = tmp;
            return A.equals(new String(swappedString));
        }
        return false;
    }

    public boolean buddyStrings1(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray()) {
                s.add(c);
            }
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                dif.add(i);
            }
        }
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        String A = "ab", B = "ba";
        System.out.println(bs.buddyStrings(A,B));
        A = "ab"; B = "ab";
        System.out.println(bs.buddyStrings(A,B));
        A = "aa"; B = "aa";
        System.out.println(bs.buddyStrings(A,B));
        A = "aaaaaaabc"; B = "aaaaaaacb";
        System.out.println(bs.buddyStrings(A,B));
    }
}
