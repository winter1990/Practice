package practice.leetcode.hard;

import java.util.*;

/**
 * @search
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation
 * sequence(s) from beginWord to endWord
 *
 * problems to solve:
 * 1. bfs all the words that in the word list that can be transformed
 * 2.
 */
public class WordLadder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        buildMap(beginWord, endWord, dict, map);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        findLadderList(beginWord, endWord, list, map, res);
        return res;
    }

    private void findLadderList(String begin, String end, List<String> list, Map<String, List<String>> map, List<List<String>> res) {
        if (begin.equals(end)) res.add(new ArrayList<>(list));
        if (!map.containsKey(begin)) return;
        for (String s : map.get(begin)) {
            list.add(s);
            findLadderList(s, end, list, map, res);
            list.remove(list.size() - 1);
        }
    }

    private void buildMap(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> map) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        boolean isFound = false, isBackward = false;
        while (!beginSet.isEmpty() && !isFound) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                isBackward = !isBackward;
            }
            Set<String> set = new HashSet<>();
            for (String w : beginSet) {
                visited.add(w);
                for (String next : getNextList(w, dict)) {
                    if (visited.contains(next) || beginSet.contains(next)) continue;
                    if (endSet.contains(next)) isFound = true;
                    set.add(next);
                    String k = isBackward ? next : w;
                    String v = isBackward ? w : next;
                    map.computeIfAbsent(k, a -> new ArrayList<>()).add(v);
                }

            }
            beginSet = set;
        }
    }

    private List<String> getNextList(String w, Set<String> dict) {
        List<String> list = new ArrayList<>();
        char[] cs = w.toCharArray();
        for (int i = 0; i < w.length(); i++) {
            char oldChar = cs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) continue;
                cs[i] = c;
                String s = new String(cs);
                if (dict.contains(s)) {
                    list.add(s);
                }
            }
            cs[i] = oldChar;
        }
        return list;
    }

    public static void main(String[] args) {
        WordLadder_II w = new WordLadder_II();
        List<String> in = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(w.findLadders("hit", "cog", in));
    }
}
