package practice.interview.google;

import java.util.HashMap;
import java.util.Map;

public class MatchWordInDictionary {

    public static void main(String[] args) {
        String[] dict = {"aaa","aab","abbb","ccc"};
        MatchWordSystem m = new MatchWordSystem(dict);
        System.out.println(m.type('a'));
        System.out.println(m.type('a'));
        System.out.println(m.type('a'));
        System.out.println(m.type('e'));
        System.out.println(m.type('b'));
        System.out.println(m.type('b'));
        System.out.println(m.type('b'));
        System.out.println(m.type('c'));
        System.out.println(m.type('c'));
        System.out.println(m.type('c'));
    }
}

class MatchWordSystem {
    String input;
    TrieNode root;
    public MatchWordSystem(String[] dict) {
        input = "";
        root = new TrieNode();
        for (String word : dict) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
    }

    public boolean type(char c) {
        input += c;
        int i = input.length() - 1;
        TrieNode node = root;
        for (; i >= 0; i--) {
            char ch = input.charAt(i);
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
                if (!node.word.equals("")) return true;
            } else {
                break;
            }
        }
        return !node.word.equals("");
    }

}

class TrieNode {
    String word;
    Map<Character, TrieNode> children;
    public TrieNode() {
        children = new HashMap<>();
        word = "";
    }
}