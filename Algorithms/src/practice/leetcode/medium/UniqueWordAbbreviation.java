package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {
}

class ValidWordAbbr {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getAbbreviation(s);
            if (!map.containsKey(key)) {
                map.put(key, s);
            } else {
                String str = map.get(key);
                if (!str.equals(s)) {
                    map.put(key, "");
                }
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getAbbreviation(word)) || map.get(getAbbreviation(word)).equals(word);
    }

    private String getAbbreviation(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
    }
}