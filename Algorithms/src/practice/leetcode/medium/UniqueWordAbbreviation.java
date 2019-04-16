package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @string
 * @design
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 *
 * problem to solve:
 * 1. find and compare if two words have the same abbreviation
 * 2. quick look up for a string in the dict to see if it is unique in the dict
 * 3. if the word is not in the dict
 *
 * pre-process each string -> first letter + count middle + last letter
 * need to identify if a same abbr has appeared
 *   map, abbr key, value is string, if contains key change value to special char / empty. otherwise, put abbr and word
 * to check the string:
 *   get abbr first
 *   abbr in the dict - value "" (false) or value a word and same (true)
 *   abbr not in dict - true
 *
 */
public class UniqueWordAbbreviation {
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
                    if (!str.equals(s)) map.put(key, "");
                }
            }
        }

        public boolean isUnique(String word) {
            return !map.containsKey(getAbbreviation(word)) || map.get(getAbbreviation(word)).equals(word);
        }

        private String getAbbreviation(String s) {
            if (s.length() <= 2) return s;
            return s.charAt(0) + (s.length() - 2 + "") + s.charAt(s.length() - 1);
        }
    }
}

