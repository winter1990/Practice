package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 *
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * ababcbacadefegdehijhklij -> [9,7,8] "ababcbaca", "defegde", "hijhklij"
 *
 * use an array to track the last occurrence of the character char[26]
 * define two variables (pre and last) as the left and right boundary of the window
 * scan through the string, extend the right bound of the window
 * until i == last, which means within this window, it contains all the occurrences of the characters inside
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) index[S.charAt(i) - 'a'] = i;
        int pre = 0, last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, index[S.charAt(i) - 'a']);
            if (i == last) {
                res.add(last - pre + 1);
                pre = last + 1;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels1(String S) {
        List<Integer> res = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] freq = new int[26];
        char[] cs = S.toCharArray();
        for (char c : cs) {
            freq[c - 'a']++;
        }
        int last = 0;
        int cur = 0;
        Set<Character> set = new HashSet<>();

        while (cur < cs.length) {
            set = new HashSet<>();
            set.add(cs[last]);
            while (!set.isEmpty() && freq[cs[cur] - 'a'] != 0) {
                set.add(cs[cur]);
                freq[cs[cur] - 'a']--;
                if (freq[cs[cur] - 'a'] == 0) {
                    set.remove(cs[cur]);
                }
                cur++;
            }
            res.add(cur - last);
            last = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels(s));
    }
}
