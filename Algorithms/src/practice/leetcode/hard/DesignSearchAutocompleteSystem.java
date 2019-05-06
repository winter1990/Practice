package practice.leetcode.hard;

import java.util.*;

/**
 * @design
 *
 * Users may input a sentence (at least one word and end with a special character '#'). For each character they type
 * except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence
 * already typed.
 *
 * problems to solve:
 * 1. keep track of top frequency of sentences
 * 2. when typing a char, search in history that matches the input string
 *
 * operation: input(char c)
 * one character each time - twp types of input
 *   letter - search history
 *   # - save to history
 * result:
 *   need to return top 3 in history
 *   if there is a tie, ASCII order
 * the sentences of history is given
 */
public class DesignSearchAutocompleteSystem {
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
            while(!pq.isEmpty() && result.size() < 3) result.add(pq.poll().sentence);
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

    /**
     * for each trie node:
     *   map char to next trie node
     *   map sentence to count/frequency becase each char may consists of multiple sentences
     *   a flag to determine current node/char is the last char in history sentence
     *
     * operations:
     * input(char c)
     *   if #, save to history -> method to save (shared with method when initializing), reset input
     *   if letter/digit, search the input string from root
     *     check if exist, if null then return empty
     *     when reaching last char, get the map of current node - might have multiple key value pairs
     *       use a max heap to get top 3 pairs -> pair(string, int)
     */
    class AutocompleteSystem1 {
        TrieNode root;
        String input;
        public AutocompleteSystem1(String[] sentences, int[] times) {
            root = new TrieNode();
            input = "";
            for (int i = 0; i < sentences.length; i++) buildTrie(sentences[i], times[i]);
        }

        private void buildTrie(String s, int count) {
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
                buildTrie(input, 1);
                this.input = "";
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
            while (!pq.isEmpty() && res.size() < 3) res.add(pq.poll().s);
            return res;
        }

        class TrieNode {
            Map<Character, TrieNode> children;
            Map<String, Integer> counts;
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
    }
}

