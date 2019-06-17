package practice.leetcode.hard;

import java.util.*;

/**
 * @topological
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules
 * of this new language. Derive the order of letters in this language.
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 * Output: "wertf"
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 * Output: ""
 *
 * compare words [w1 w2], [w2 w3]
 *   scan through two strings, index=[0, min(l1 l2)]
 *   if same char continue
 *   if not same, abk abf - k < f, ako azo, k<z, we cannot decide f and z, map char and set<char>
 *
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) degree.put(c, 0);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    Set<Character> set = map.containsKey(word1.charAt(j)) ? map.get(word1.charAt(j)) : new HashSet<>();
//                    if (map.containsKey(word1.charAt(j))) {
//                        set = map.get(word1.charAt(j));
//                    }
                    if (!set.contains(word2.charAt(j))) {
                        set.add(word2.charAt(j));
                        map.put(word1.charAt(j), set);
                        degree.put(word2.charAt(j), degree.get(word2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            if (map.containsKey(cur)) {
                for (char c : map.get(cur)) {
                    degree.put(c, degree.get(c) - 1);
                    if (degree.get(c) == 0) {
                        q.offer(c);
                    }
                }
            }
        }

        return sb.length() == degree.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
//        String[] str = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        // r<x x<q q<j j<d z<h d<j j<f f<o
                // {"za","zb","ca","cb"};// a<b z<c a<b
                //{"wrt", "wrf", "er", "ett", "rftt"};
        String[] str = {"c", "b", "a"};
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(str));
    }

    public String alienOrder1(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}
