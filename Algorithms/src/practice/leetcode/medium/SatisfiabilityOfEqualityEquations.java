package practice.leetcode.medium;

import java.util.*;

/**
 * @graph Return true if and only if it is possible to assign integers to variable names
 * so as to satisfy all the given equations.
 * ["a==b","b!=c","c==a"] false
 * ["a==b","b==c","a==c"] true
 * ["c==c","b==d","x!=z"] true
 * ["b==a","a==b"] true
 * <p>
 * what really break the law is !=
 * we build a graph based on equal equations
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] sets = new int[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = i;
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int u = find(sets, eq.charAt(0) - 'a');
                int v = find(sets, eq.charAt(3) - 'a');
                sets[u] = v;
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = find(sets, eq.charAt(0) - 'a');
                int v = find(sets, eq.charAt(3) - 'a');
                if (u == v) return false;
            }
        }
        return true;
    }

    private int find(int[] sets, int x) {
        if (x != sets[x]) {
            sets[x] = find(sets, sets[x]);
        }
        return sets[x];
    }

    /**
     public boolean equationsPossible(String[] equations) {
     if (equations == null || equations.length == 0) {
     return true;
     }
     Map<Character, Set<Character>> map = new HashMap<>();
     for (String equation : equations) {
     if (equation.charAt(1) == '=') {
     char start = equation.charAt(0);
     char end = equation.charAt(3);
     map.put(start, map.getOrDefault(start, new HashSet<>()));
     map.get(start).add(end);
     map.put(end, map.getOrDefault(end, new HashSet<>()));
     map.get(end).add(start);
     }
     }
     for (String equation : equations) {
     if (equation.charAt(1) == '!') {
     char start = equation.charAt(0);
     char end = equation.charAt(3);
     if (start == end) return false;
     if (map.containsKey(start) && map.containsKey(end)) {
     if (map.get(start).contains(end)) {
     return false;
     }
     for (Character c : map.get(start)) {
     if (map.get(c).contains(end)) {
     return false;
     }
     }
     }
     }
     }
     return true;
     }
     */
}
