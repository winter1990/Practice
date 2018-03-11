package practice.leetcode.hard;

import java.util.*;

/*
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
The correct order is: "wertf"

  "z",
  "x"
The correct order is: "zx".

  "z",
  "x",
  "z"
The order is invalid, so return "".
 */

/**
 * "wrt","wrf","er","ett","rftt" -> wertf
 *  111   112   21   222   3222
 *  t<f w<e r<t e<r
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Integer> levelMap = new HashMap<>();
        Map<Character, Set<Character>> neighborMap = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
//                neighborMap.put(c, new HashSet<>());
                levelMap.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    Set<Character> set = new HashSet<Character>();
                    if (neighborMap.containsKey(word1.charAt(j))) {
                        set = neighborMap.get(word1.charAt(j));
                    }
                    if(!set.contains(word2.charAt(j))){
                        set.add(word2.charAt(j));
                        neighborMap.put(word1.charAt(j), set);
                        levelMap.put(word2.charAt(j), levelMap.get(word2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : levelMap.keySet()) {
            if (levelMap.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            if (neighborMap.containsKey(cur)) {
                for (char c : neighborMap.get(cur)) {
                    levelMap.put(c, levelMap.get(c) - 1);
                    if (levelMap.get(c) == 0) {
                        q.offer(c);
                    }
                }
            }
        }

        return sb.length() == levelMap.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String[] str = {"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        // r<x x<q q<j j<d z<h d<j j<f f<o
                // {"za","zb","ca","cb"};// a<b z<c a<b
                //{"wrt", "wrf", "er", "ett", "rftt"};
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
