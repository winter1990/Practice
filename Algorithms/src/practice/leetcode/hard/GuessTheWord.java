package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @String
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
        words.addAll(Arrays.asList(wordlist));
        for (int k = 0, count = 0; k < 10 && count < 6; k++) {
            String guess = words.get(new Random().nextInt(words.size()));
            count = master.guess(guess);
            List<String> tmp = new ArrayList<>();
            for (String w : words) {
                if (countSameChars(w, guess) == count) tmp.add(w);
            }
            words = tmp;
        }
    }

    private int countSameChars(String a, String b) {
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) c++;
        }
        return c;
    }

    class Master {
        public int guess(String s) {
            return 0;
        }
    }

}
