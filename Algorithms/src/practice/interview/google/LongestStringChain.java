package practice.interview.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * i, in, sin, sing, sting, sings, stingy
 *
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
    }
}
