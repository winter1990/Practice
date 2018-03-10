package practice.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * partition this string into as many parts as possible so that each letter appears in at most one part
 * ababcbacadefegdehijhklij -> [9,7,8] "ababcbaca", "defegde", "hijhklij"
 * arr[26] track the freq of char
 * each time,add to set
 * ababc [2 2 1]
 * [a]  [1 2 1], [ab] [1 1 1], [b] [0 1 1], [] [0 0 1],
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int last = 0;
        int pre = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if (last == i) {
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
