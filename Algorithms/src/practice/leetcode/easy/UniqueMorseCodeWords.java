package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @string
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
 * "...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-").
 * We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(code[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
