package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) list.add(words[i + 2]);
        }
//        return list.toArray(new String[0]); // works
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

}
