package practice.leetcode.hard;

import java.util.*;

/**
 * @string
 * @heap
 *
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least
 * distance k from each other.
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an
 * empty string "".
 *
 * Input: s = "aabbcc", k = 3 Output: "abcabc"
 * Input: s = "aaabc", k = 3 Output: ""
 * Input: s = "aaadbbcc", k = 2 Output: "abacabcd"
 *
 * count the frequency of each char
 * aaabbcd k = 3 -> ....... -> a..a..a -> ab.ab.a -> abcab.a -> abcabda
 * index: 0 3 6 1 4 2 5
 */
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        if (k <= 1) return s;
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.f - p1.f);
        for (char c : freq.keySet()) pq.offer(new Pair(c, freq.get(c)));
        Queue<Pair> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            sb.append(cur.c);
            cur.f--;
            q.offer(cur);
            if (q.size() < k) continue;
            Pair p = q.poll();
            if (p.f > 0) pq.offer(p);
        }
        return sb.length() == n ? sb.toString() : "";
    }

    class Pair {
        int f;
        char c;
        public Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

    // can handle most of cases but abcdabcdabdeac 4
    public String rearrangeString1(String s, int k) {
        if (s == null || s.length() == 0) return "";
        if (k <= 1) return s;
        int n = s.length();
        char[] res = new char[n];
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.f - p1.f);
        for (char c : freq.keySet()) pq.offer(new Pair(c, freq.get(c)));
        if (pq.peek().f * k - (k - 1) > n) return "";

        int index = 0, offset = 0;
        Pair p = pq.poll();
        for (int i = 0; i < n; i++) {
            res[index] = p.c;
            index += k;
            p.f--;
            if (index >= n) {
                index = ++offset;
                if (p.f != 0) {
                    for (int j = Math.max(index - k + 1, 0); j < Math.min(n, index + k); j++) {
                        if (res[j] == p.c)
                            return "";
                    }
                }
            }
            if (p.f == 0) p = pq.poll();
        }
        return new String(res);
    }


    // abcdabcdabdeac 4 -> 4a3b3c3d1e a...a...a...a. abd.abd.ab..ad
    // act abdcabdcabcead

    public static void main(String[] args) {
        RearrangeStringKDistanceApart r = new RearrangeStringKDistanceApart();
        String s = "aaadbbcc";  // aa   aabbcc    aaadbbcc  abcdabcdabdeac
        int k = 2;            // 0    4 3       2   4
        System.out.println(r.rearrangeString(s, k));
    }
}

// exp abcdabcdabcdae