package practice.interview.google;

import java.util.*;

/**
 * i, in, sin, sing, sting, sings, stingy
 *
 */
public class LongestStringChain {
    public int longestChain(String[] strs) {
        Set<String> set = new HashSet<>();
        for (String s : strs) set.add(s);
        Arrays.sort(strs, (a,b) -> b.length() - a.length());
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            int len = getLengthOfChain(strs[i], set);
            max = Math.max(max, len);
        }
        return max;
    }

    private int getLengthOfChain(String s, Set<String> set) {
        StringBuilder sb = new StringBuilder(s);
        int count, max = 1;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if (set.contains(sb.toString())) {
                count = 1 + getLengthOfChain(sb.toString(), set);
                max = Math.max(max, count);
            }
            sb.insert(i, c);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] in = {"i", "in", "sin", "sing", "sting", "sings", "stingy"};
//        String[] in = {"abcdef","abdef","adef", "abcef","abef","bef","qwert","wert","wrt","wr","w"};
        LongestStringChain l = new LongestStringChain();
        System.out.println(l.longestChain(in));
        System.out.println(l.getLongestChain(in));
    }

    // 给一个set of words，求一个在这个set中最长的word，他是set中另外一个word可以在任意位置插入一个character后产生的，
    // 并且这个较短的word也要符合这个规则。比如[a, ab, cab, c, x, xy, tttt], 最长的word是cab，因为得到他的顺序是a->ab->cab
    public int getLongestChain(String[] strs) {
        Set<String> set = new HashSet<>();
        for (String s : strs) set.add(s);
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < strs.length && strs[i].length() == 1; i++) q.offer(strs[i]);
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            max++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                q.addAll(getNextList(cur, set));
            }
        }
        return max;
    }

    private List<String> getNextList(String w, Set<String> set) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(w);
        for (int i = 0; i <= sb.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                sb.insert(i, c);
                if (set.contains(sb.toString())) list.add(sb.toString());
                sb.deleteCharAt(i);
            }
        }
        return list;
    }
}
