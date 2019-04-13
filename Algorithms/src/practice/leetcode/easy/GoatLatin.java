package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @string
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 *
 * use a set to store all the vowels -> lower and upper cases
 *
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!vowels.contains(words[i].charAt(0))) {
                if (words[i].length() > 1) {
                    words[i] = words[i].substring(1) + words[i].charAt(0);
                }
            }
            words[i] += "ma";
            for (int j = 0; j <= i; j++) {
                words[i] += "a";
            }
        }
        for (String word : words) {
            sb.append(word).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
