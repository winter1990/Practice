package practice.interview.google;

import java.util.*;

/**
 * dict: a, an, the, tank, ten, bet, ant, cut
 * char set:  [a, t, n, e]
 * return the longest words that all chars in char set
 * can only use once for each char
 */
public class FindWordsInCharSet {
    public List<String> findWords(Set<String> dict, char[] chars) {
        int max = -1;
        int[] freq = new int[256];
        for (char c : chars) {
            freq[c - 'a']++;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : dict) {
            int[] checker = freq.clone();
            int i = 0;
            for (; i < s.length(); i++) {
                int val = s.charAt(i) - 'a';
                checker[val]--;
                if (checker[val] < 0) {
                    break;
                }
            }
            if (i == s.length()) {
                addToMap(map, s);
                max = Math.max(max, s.length());
            }
        }
        return map.get(max);
    }

    private void addToMap(Map<Integer, List<String>> map, String s) {
        if (!map.containsKey(s.length())) {
            List<String> list = new LinkedList<>();
            map.put(s.length(), list);
        }
        map.get(s.length()).add(s);
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String[] ss = {"a", "an", "the", "tank", "ten", "bet", "ant", "cut"};
        set.addAll(Arrays.asList(ss));
        char[] cs = {'a', 't', 'n', 'e', 'k'};
        FindWordsInCharSet fw = new FindWordsInCharSet();
        System.out.println(fw.findWords(set, cs));
    }
}
