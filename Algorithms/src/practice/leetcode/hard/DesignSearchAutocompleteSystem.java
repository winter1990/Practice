package practice.leetcode.hard;

import java.util.*;

public class DesignSearchAutocompleteSystem {
    // https://leetcode.com/problems/design-search-autocomplete-system/discuss/176550/Java-simple-solution-without-using-Trie-(only-use-HashMap-and-PriorityQueue)
    class AutocompleteSystem {
        Map<String, Integer> database = new HashMap<>();
        String data = "";

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                database.put(sentences[i], database.getOrDefault(sentences[i], 0) + times[i]);
            }
        }

        public List<String> input(char c) {
            if ('#' == c) {
                database.put(data, database.getOrDefault(data, 0) + 1);
                data = "";
                return new ArrayList<>();
            }

            data += c;
            PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.sentence.compareTo(b.sentence) : b.count - a.count));
            for (String s : database.keySet()) {
                if (s.startsWith(data)) queue.offer(new Pair(s, database.get(s)));
            }

            List<String> result = new ArrayList<>();
            while(!queue.isEmpty() && result.size() < 3) {
                Pair a = queue.poll();
                result.add(a.sentence);
            }
            return result;
        }

        public class Pair {
            String sentence;
            int count;
            public Pair(String s, int c) {
                sentence = s;
                count = c;
            }
        }
    }

    // https://leetcode.com/problems/design-search-autocomplete-system/discuss/105376/Java-solution-Trie-and-PriorityQueue
    class AutocompleteSystem1 {
        class TrieNode {
            Map<Character, TrieNode> children;
            Map<String, Integer> counts;
            boolean isWord;
            public TrieNode() {
                children = new HashMap<Character, TrieNode>();
                counts = new HashMap<String, Integer>();
                isWord = false;
            }
        }

        class Pair {
            String s;
            int c;
            public Pair(String s, int c) {
                this.s = s; this.c = c;
            }
        }

        TrieNode root;
        String prefix;

        public AutocompleteSystem1(String[] sentences, int[] times) {
            root = new TrieNode();
            prefix = "";
            for (int i = 0; i < sentences.length; i++) {
                add(sentences[i], times[i]);
            }
        }

        private void add(String s, int count) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    curr.children.put(c, next);
                }
                curr = next;
                curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
            }
            curr.isWord = true;
        }

        public List<String> input(char c) {
            if (c == '#') {
                add(prefix, 1);
                prefix = "";
                return new ArrayList<String>();
            }

            prefix = prefix + c;
            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<String>();
                }
                curr = next;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
            for (String s : curr.counts.keySet()) {
                pq.add(new Pair(s, curr.counts.get(s)));
            }

            List<String> res = new ArrayList<String>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().s);
            }
            return res;
        }
    }
}

