package practice.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @string
 *
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly
 * K times so that the resulting string equals B.
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 *
 * ab ba -> 1
 * abc bca -> cba bca 2
 * abac baba -> 2
 *
 * if the char at i in s1 and s2 same, continue
 * if not same
 *   find the position that after swapping, both are match, then we are solving two chars in a string
 *   if there is no such char, then swap with any? cbdea abcde
 * use bfs to find the shortest path to transit s1 to s2
 */
public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(A);
        Queue<String> q = new LinkedList<>();
        q.offer(A);
        int n = A.length(), count = 0;
        while (!q.isEmpty()) {
            ++count;
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                int i = 0;
                while (s.charAt(i) == B.charAt(i)) i++;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == s.charAt(i) || s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) continue;
                    String tmp = swap(s, i, j);
                    if (tmp.equals(B)) return count;
                    if (visited.add(tmp)) q.offer(tmp);
                }
            }
        }
        return count;
    }

    private String swap(String s, int i, int j) {
        char[] cs = s.toCharArray();
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
        return new String(cs);
    }

    public static void main(String[] args) {
        KSimilarStrings k = new KSimilarStrings();
        System.out.println(k.kSimilarity("ab", "ba"));
    }
}
