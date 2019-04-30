package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 *
 * Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
 *
 * problems to solve:
 * 1. when a query matches multiple words, apply the correct rule to change the query
 * 2. quick look up the dictionary
 *
 * the rules:
 * exact match - return original
 * capitalization, return the first
 * vowel error, return the first
 * no match, return ""
 *
 * use a map to store and group - Abc abc
 */
public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, List<String>> map = new HashMap<>();
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a','e','i','o','u'));
        for (String w : wordlist) {
            String newWord = getLowerNonVowel(w, vowels);
            map.computeIfAbsent(newWord, m -> new ArrayList<>()).add(w);
        }
        int n = queries.length, index = 0;
        String[] res = new String[n];
        for (String q : queries) {
            String newQuery = getLowerNonVowel(q, vowels);
            if (!map.containsKey(newQuery)) {
                res[index] = "";
            } else {
                if (map.get(newQuery).contains(q)) {
                    res[index] = q;
                } else {
                    List<String> list = map.get(newQuery);
                    int i = 0;
                    String tmp = "";
                    for (; i < list.size(); i++) {
                        if (list.get(i).toLowerCase().equals(q.toLowerCase())) {
                            res[index] = list.get(i);
                            break;
                        } else {
                            tmp = tmp.equals("") ? list.get(i) : tmp;
                        }
                    }
                    if (i == list.size()) res[index] = tmp;
                }
            }
            index++;
        }
        return res;
    }

    private String getLowerNonVowel(String s, Set<Character> vowels) {
        String lo = s.toLowerCase();
        char[] cs = lo.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (vowels.contains(cs[i])) cs[i] = '*';
        }
        return new String(cs);
    }

    public String[] spellchecker1(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) {
                res[i] = queries[i];
                continue;
            }
            String lower = queries[i].toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                res[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                res[i] = vowel.get(devowel);
            } else {
                res[i] = "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        VowelSpellchecker v = new VowelSpellchecker();
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        v.spellchecker1(wordlist, queries);
    }
}
