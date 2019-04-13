package practice.leetcode.question;

import java.util.*;

/**
 * @string
 * @trie
 *
 * 1. Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 * 2. If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead
 *    of only the first character until making the map from word to abbreviation become unique.
 *    In other words, a final abbreviation cannot map to more than one original words.
 * 3. If the abbreviation doesn't make the word shorter, then keep it as original.
 *
 * some thoughts:
 * 1. group it with length -> sort by length and ordered
 * 2. only consider length > 3
 *
 */
public class WordAbbreviation {
    /**
     * group the words based on initial abbreviation
     * find and resolve the conflict
     *   build up the tree
     */
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<Integer>> map = new HashMap<>();
        int n = dict.size();
        for (int i = 0; i < n; i++) {
            String w = dict.get(i);
            String abbr = getAbbr(w);
            if (!map.containsKey(abbr)) map.put(abbr, new ArrayList<>());
            map.get(abbr).add(i);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            String abbr = e.getKey();
            List<Integer> idx = e.getValue();
            resolve(dict, abbr, idx, res);
        }
        return res;
    }

    private void resolve(List<String> dict, String abbr, List<Integer> idx, List<String> res) {
        if (idx.size() == 1) {
            res.add(dict.set(idx.get(0), abbr));
            return;
        }
        TrieNode root = buildTree(dict, idx);
        for (int p : idx) {
            String w = dict.get(p);
            TrieNode cur = root;
            int i = 0;
            int n = w.length();
            while (i < n && cur.child.get(w.charAt(i)).count > 1) {
                cur = cur.child.get(w.charAt(i));
                i++;
            }
            if (i >= n - 3) {
                res.set(p, w);
            } else {
                String pre = w.substring(0, i + 1);
                String st = pre + (n - i - 2) + "" + w.charAt(n - 1);
                res.set(p, st);
            }
        }
    }

    private TrieNode buildTree(List<String> dict, List<Integer> idx) {
        TrieNode root = new TrieNode();
        for (int p : idx) {
            String w = dict.get(p);
            TrieNode cur = root;
            for (int i = 0; i < w.length(); i ++) {
                char c = w.charAt(i);
                if (cur.child.containsKey(c)) {
                    cur = cur.child.get(c);
                } else {
                    TrieNode next = new TrieNode();
                    cur.child.put(c, next);
                    cur = next;
                }
                cur.count++;
            }
        }
        return root;
    }

    private String getAbbr(String w) {
        if (w.length() < 4) return w;
        return w.charAt(0) + "" + (w.length() - 2) + w.charAt(w.length() - 1);
    }

    class TrieNode {
        Map<Character, TrieNode> child;
        int count;
        public TrieNode() {
            child = new HashMap<>();
            count = 0;
        }
    }

    public List<String> wordsAbbreviation1(List<String> dict) {
        int len = dict.size();
        String[] ans = new String[len];
        int[] prefix = new int[len];
        for (int i = 0; i < len; i++) {
            prefix[i] = 1;
            ans[i] = makeAbbr(dict.get(i), 1);
        }
        for (int i = 0; i < len; i++) {
            while (true) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i + 1; j < len; j++) {
                    if (ans[j].equals(ans[i])) set.add(j);
                }
                if (set.isEmpty()) break;
                set.add(i);
                for (int k : set)
                    ans[k] = makeAbbr(dict.get(k), ++prefix[k]);
            }
        }
        return Arrays.asList(ans);
    }

    private String makeAbbr(String s, int k) {
        if (k >= s.length() - 2) return s;
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(0, k));
        builder.append(s.length() - 1 - k);
        builder.append(s.charAt(s.length() - 1));
        return builder.toString();
    }
}
