package practice.leetcode;

/*
Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/

import java.util.*;

/**
 * two end solution
 * search from start and end word
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    /**
     * multiple paths might be, find shortest
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
        Queue<String> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(beginWord);
        q2.offer(1);
        while (!q1.isEmpty()) {
            String s = q1.poll();
            int step = q2.poll();
            if (s.equals(endWord)) {
                return step;
            }
            for (int i = 0; i < s.length(); i++) {
                char[] cs = s.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    cs[i] = c;
                    String ss = new String(cs);
                    if (wordList.contains(ss)) {
                        q1.offer(ss);
                        q2.offer(step + 1);
                        wordList.remove(ss);
                    }
                }
            }
        }
        return 0;
    }
}
