package practice.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * split the sentence
 *
=======
 * @string
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s");
        for (String word : words) {
            String pre = "";
            for (int i = 1; i <= word.length(); i++) {
                pre = word.substring(0, i);
                if (set.contains(pre)) break;
            }
            sb.append(pre + " ");
        }
        return sb.toString().trim();
    }
}
