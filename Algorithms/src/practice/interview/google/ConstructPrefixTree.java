package practice.interview.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructPrefixTree {
    public TrieNode buildTrie(String[] words) {
        Arrays.sort(words);
        int pre = 0;
        TrieNode root = new TrieNode();
//        root.map.put(words[0], new TrieNode());
        for (int i = 0; i < words.length; i++) {
            String prefix = words[pre];
            if (!words[i].startsWith(prefix)) {
                pre = i;
            }
            insert(root, pre, i, words);
        }
        return root;
    }

    // aa aab aabcd aabd aabde bcd
    private void insert(TrieNode root, int pre, int index, String[] words) {
        TrieNode cur = root;
        for (int i = pre; i < index; i++) {
            if (words[index].startsWith(words[i])) {
                cur = cur.map.get(words[i]);
            }
        }
        cur.map.put(words[index], new TrieNode());
    }

    class TrieNode {
        Map<String, TrieNode> map;
        public TrieNode() {
            map = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        ConstructPrefixTree c = new ConstructPrefixTree();
        TrieNode n = c.buildTrie(new String[]{"ab", "abcd", "abee", "bcd", "bcf", "bcfg"});
        System.out.println();
    }
}
