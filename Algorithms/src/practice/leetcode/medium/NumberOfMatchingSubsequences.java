package practice.leetcode.medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 *
 * normal matching is not efficient
 *
 * sort - a acd ace bb
 * merge - abbcde
 * not working
 *
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) map.put(c, new LinkedList<>());
        for (String w : words) map.get(w.charAt(0)).addLast(w);

        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> q = map.get(c);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.removeFirst();
                if (w.length() == 1) {
                    count++;
                } else {
                    map.get(w.charAt(1)).addLast(w.substring(1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        NumberOfMatchingSubsequences nom = new NumberOfMatchingSubsequences();
        System.out.println(nom.numMatchingSubseq(s, words));
    }

    /** does not work
    // use map to track the range of appearance
    // a->[1,50] b->[10 25] c->[7,15] d->[51,55]...
    // abdc
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, i});
            } else {
                map.get(c)[0] = Math.min(map.get(c)[0], i);
                map.get(c)[1] = Math.max(map.get(c)[1], i);
            }
        }
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            int left = map.get(words[0].charAt(0))[0];
            int right = map.get(words[0].charAt(0))[1];
            int index = 1;
            while (index < words[i].length()) {
                if (!map.containsKey(words[i].charAt(index)) || map.get(words[i].charAt(index))[1] < left) {
                    break;
                } else {
                    left = Math.max(left, map.get(words[i].charAt(index))[0]);
                    right = Math.min(right, map.get(words[i].charAt(index))[1]);
                    index++;
                }
            }
            if (index == words[i].length()) count++;
        }
        return count;
    }
    */

    public int numMatchingSubseq1(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            if (isMatching(S, w)) count++;
        }
        return count;
    }

    private boolean isMatching(String s, String w) {
        int offset = 0;
        for (int i = 0; i < w.length(); i++) {
            int index = s.substring(offset).indexOf(w.charAt(i));
            if (index == -1) {
                return false;
            }
            offset += (index + 1);
        }
        return true;
    }

}