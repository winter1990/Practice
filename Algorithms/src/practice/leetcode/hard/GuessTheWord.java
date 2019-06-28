package practice.leetcode.hard;

import javafx.util.Pair;

import java.util.*;

/**
 * @string
 * @minimax
 *
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.
 * You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the
 * original list with 6 lowercase letters.
 * This function returns an integer type, representing the number of exact matches (value and position) of your guess to
 * the secret word.
 *
 * randomly choose a word in the list
 * call guess() and get the number of chars that are matched
 * from the list, get the same match
 * repeat 10 times
 */
public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new ArrayList<>();
        for (String w : wordlist) words.add(w);
        Random random = new Random();
        for (int i = 0, match = 0; i < 10 && match < 6; i++) {
            int index = random.nextInt(words.size());
            String guess = words.get(index);
            match = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            getNextWordsSet(guess, match, words, candidates);
            words = candidates;
        }
    }

    private void getNextWordsSet(String guess, int match, List<String> words, List<String> candidates) {
        for (String w : words) {
            if (w.equals(guess)) continue;
            int count = 0;
            for (int i = 0; i < w.length(); i++) {
                if (guess.charAt(i) == w.charAt(i)) count++;
            }
            if (count == match) candidates.add(w);
        }
    }

    /**
     * focus on minimizing the worst case
     * the worst case - if call master.guess(word), we get 0
     * for each guess, our target is to narrow down the word next for next step as much as possible
     */
    public void findSecretWord1(String[] wordlist, Master master) {
        for (int i = 0, match = 0; i < 10 && match < 6; ++i) {
            Map<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2 : wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            Pair<String, Integer> minimax = new Pair<>("", 1000);
            for (String w : wordlist) {
                if (count.getOrDefault(w, 0) < minimax.getValue()) {
                    minimax = new Pair<>(w, count.getOrDefault(w, 0));
                }
            }
            match= master.guess(minimax.getKey());
            List<String> list = new ArrayList<>();
            for (String w : wordlist) {
                if (match(minimax.getKey(), w) == match) {
                    list.add(w);
                }
            }
            wordlist = list.toArray(new String[0]);
        }
    }

    public int match(String w1, String w2) {
        int c = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) c++;
        }
        return c;
    }

    class Master {
        public int guess(String s) {
            return 0;
        }
    }

}
