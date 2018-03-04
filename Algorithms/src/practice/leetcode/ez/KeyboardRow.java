package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        List<String> res = new ArrayList<>();
        for (String s : words) {
            String word = s.toLowerCase();
            if (s1.indexOf(word.charAt(0)) >= 0) {
                if (sameRow(word, s1)) res.add(s);
            } else if (s2.indexOf(word.charAt(0)) >= 0) {
                if (sameRow(word, s2)) res.add(s);
            } else if (s3.indexOf(word.charAt(0)) >= 0) {
                if (sameRow(word, s3)) res.add(s);
            }
        }
        String[] strs = new String[res.size()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = res.get(i);
        }
        return strs;
    }

    private boolean sameRow(String word, String dict) {
        for (int i = 1; i < word.length(); i++) {
            if (dict.indexOf(word.charAt(i)) == -1) return false;
        }
        return true;
    }
}
