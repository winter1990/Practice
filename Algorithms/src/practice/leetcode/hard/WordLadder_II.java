package practice.leetcode.hard;

import java.util.*;

/**
 * @search
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation
 * sequence(s) from beginWord to endWord
 *
 * problems to solve:
 * 1. start -> end
 * 2. must be shortest path, or multiple paths
 * 3. change one char at a time
 * 4. each transformation should be in the wprd list
 *
 * given list of words, to improve look up time, put all words in set
 * build up the relationship between each word -> next potential steps/words
 *   there might be multiple words in next step - map string->list of words, all words must be in the dictionary
 *   need a method to provide all potential word list, given a word and dictionary
 *     for each char in the word, change it to [a,z] and check if exists in the dict (skip original word)
 *     return a list of words
 *   two set of words
 *     begin set and end set
 *     bi-directional search -> compare the size of two set and start with the smaller one
 *   use a set to store visited words
 *   for each word in the start set
 *     mark as visited
 *     get the list of words for next level
 *     for each in next level list
 *       if not visited
 *       add to the set as next level
 *       add to the map
 *     start = next level set
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
//        List<String> in = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<String> in = new ArrayList<>(Arrays.asList("hgt","hot","dot","dog","lot","log","cog","cot"));
        System.out.println(w.findLadders("hit", "cot", in));
    }
}
