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
 *
 * Input: A = "ab", B = "ba", Output: true
 * Input: A = "ab", B = "ab", Output: false
 * Input: A = "aa", B = "aa", Output: true
 * Input: A = "aaaaaaabc", B = "aaaaaaacb", Output: true
 *
 * two string must have same length, and larger than 1
 * two string must be the permutation with each other, which means the chars in each should have the same frequency
 * if two strings are the same
 *   there must be some char appears at least twice
 * if two strings are not same
 *   exactly two chars different
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() < 2) return false;
        int[] checker = new int[26];
        boolean hasDuplicate = false;
        for (char c : A.toCharArray()) {
            checker[c - 'a']++;
            if (checker[c - 'a'] > 1) hasDuplicate = true;
        }
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) diff++;
            checker[B.charAt(i) - 'a']--;
            if (checker[B.charAt(i) - 'a'] < 0) return false;
        }
        return hasDuplicate ? (diff == 0 || diff == 2) : diff == 2;
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
