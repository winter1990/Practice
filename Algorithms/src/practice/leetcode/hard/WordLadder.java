package practice.leetcode.hard;

import java.util.*;

/**
 * @string
 * @bfs
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * find the next step first:
 * start with begin word, for each character, replace it with other chars in [a,z] (skip the original char)
 * and see whether it exists in the dictionary
 * there might be multiple words for next step
 * store all of them
 * in next level, go through all the words, repeat the replacement and check in dict
 *
 * two end solution
 * search from start and end word
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = cs[i];
                        cs[i] = c;
                        String str = new String(cs);
                        if (endSet.contains(str)) {
                            return step + 1;
                        }
                        if (!visited.contains(str) && dict.contains(str)) {
                            temp.add(str);
                            visited.add(str);
                        }
                        cs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }

    /**
     * there might have multiple paths, find the shortest
     * 1. each step, need to track multiple words and steps - two queues
     * 2. how to find the difference - compare with each in list
     * O(m*n*26)
     *
     * Time limit exceeded
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordList.remove(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                for (String s : helper(cur,  wordList)) {
                    q.offer(s);
                }
            }
            step++;
        }
        return 0;
    }

    private List<String> helper(String s, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] cs = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                cs[i] = c;
                String word = new String(cs);
                if (wordList.contains(word)) {
                    wordList.remove(word);
                    res.add(word);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String s = "hit"; // hit hot dot dog cog
        String e = "cog";
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(wl.ladderLength(s, e, dict));
    }
}
