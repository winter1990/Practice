package practice.leetcode.hard;

import java.util.*;

/**
 * @design
 *
 * Users may input a sentence (at least one word and end with a special character '#'). For each character they type
 * except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence
 * already typed.
 *
 * operation: input(char c)
 * each time, one character
 * result:
 *   need to return top 3 in history
 *   if there is a tie, ASCII order
 * the sentences of history is given
 * two types of input:
 *   1. # -> store the current input in history
 *   2. look up in the history -> map(sentence,freq) -> put in priority queue to get the top 3 -> pq(Pair)
 */
public class DesignSearchAutocompleteSystem {
    // https://leetcode.com/problems/design-search-autocomplete-system/discuss/176550/Java-simple-solution-without-using-Trie-(only-use-HashMap-and-PriorityQueue)
    class AutocompleteSystem {

        Map<String, Integer> history = new HashMap<>();
        String input;
        public AutocompleteSystem(String[] sentences, int[] times) {
            input  = "";
            for (int i = 0; i < sentences.length; i++) history.put(sentences[i], history.getOrDefault(sentences[i], 0) + times[i]);
        }

        public List<String> input(char c) {
            if (c == '#') {
                history.put(input, history.getOrDefault(input, 0) + 1);
                input = "";
                return new ArrayList<>();
            }
            input += c;
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.sentence.compareTo(b.sentence) : b.count - a.count));
            for (String s : history.keySet()) {
                if (s.startsWith(input)) pq.offer(new Pair(s, history.get(s)));
            }

            List<String> result = new ArrayList<>();
            while(!pq.isEmpty() && result.size() < 3) {
                Pair a = pq.poll();
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
            Map<Character, TrieNode> children; // all neighbors
            Map<String, Integer> counts; // count the sentences frequency, for each node, we need to store all sentences
            boolean isWord;
            public TrieNode() {
                children = new HashMap<>();
                counts = new HashMap<>();
                isWord = false;
            }
        }

        class Pair {
            String s;
            int c;
            public Pair(String s, int c) {
                this.s = s;
                this.c = c;
            }
        }

        TrieNode root;
        String input;
        public AutocompleteSystem1(String[] sentences, int[] times) {
            root = new TrieNode();
            input = "";
            for (int i = 0; i < sentences.length; i++) initialize(sentences[i], times[i]);
        }

        private void initialize(String s, int count) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                TrieNode next = node.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    node.children.put(c, next);
                }
                node = next;
                node.counts.put(s, node.counts.getOrDefault(s, 0) + count);
            }
            node.isWord = true;
        }

        public List<String> input(char c) {
            if (c == '#') {
                initialize(input, 1);
                input = "";
                return new ArrayList<>();
            }
            input += c;
            TrieNode node = root;
            for (char ch : input.toCharArray()) {
                TrieNode next = node.children.get(ch);
                if (next == null) return new ArrayList<>();
                node = next;
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
            for (String s : node.counts.keySet()) pq.add(new Pair(s, node.counts.get(s)));

            List<String> res = new ArrayList<>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) res.add(pq.poll().s);
            return res;
        }
    }
}

