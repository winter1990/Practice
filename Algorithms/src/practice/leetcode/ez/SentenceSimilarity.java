package practice.leetcode.ez;

import java.util.HashSet;
import java.util.Set;

public class SentenceSimilarity {
    public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (String[] strs : pairs) {
            set.add(strs[0] + "/" + strs[1]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])
                    && !set.contains(words1[i] + "/" + words2[i])
                    && !set.contains(words2[i] + "/" + words1[i])) {
                return false;
            }
        }
        return true;
    }
}
