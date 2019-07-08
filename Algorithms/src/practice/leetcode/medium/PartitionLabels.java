package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 * @greedy
 *
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * ababcbacadefegdehijhklij -> [9,7,8] "ababcbaca", "defegde", "hijhklij"
 *
 * problems to solve:
 * 1. find multiple windows and within the window, it contains all the occurrences of all chars within
 * 2. minimize the window size and maximize the number of windows
 *
 * start with 0, expand the window:
 *   if count the occurrence, we need to scan back the substring to make sure all the chars included in the window
 *   if track the last occurrence index of char and fur each char, get the furthest index, we just maintain the last index
 * use an array to store the last occurrence of the character char[26]
 * use two pointers as the left and right boundary of the window
 * scan through the string, extend the right bound of the window
 * until i == last, which means within this window, it contains all the occurrences of the characters inside
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) lastIndex[S.charAt(i) - 'a'] = i;
        List<Integer> res = new ArrayList<>();
        int pre = 0, last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if (i == last) {
                res.add(last - pre + 1);
                pre = last + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels(s));
    }
}
