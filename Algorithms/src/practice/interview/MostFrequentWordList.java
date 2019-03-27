package practice.interview;

import java.util.*;

public class MostFrequentWordList {
    public List<String> getMostFrequentWords(String sentence) {
        List<String> res = new ArrayList<>();
        String[] words = sentence.split(" ");
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) freq.put(w, freq.getOrDefault(w, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.freq == p2.freq) {
                    return p1.word.compareTo(p2.word);
                }
                return p2.freq - p1.freq;
            }
        });
        for (String word : freq.keySet()) pq.offer(new Pair(word, freq.get(word)));
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        return res;
    }

    class Pair {
        int freq;
        String word;
        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        MostFrequentWordList m = new MostFrequentWordList();
        System.out.println(m.getMostFrequentWords("a a a cat dog fish cat cat dog"));
    }
}
