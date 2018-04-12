package practice.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到最长的字符串的长度，要求这个子字符串的头字符和尾字符相同。
 * 如abdcbe, 则最长的是bdcb,头b和尾b相同，返回4。要求时间复杂度O(n)
 */
public class LongestSubstringWithSameHeadTail {
    public int findMaxLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int  i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                max = Math.max(max, i - map.get(s.charAt(i)) + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abdcbae";
        LongestSubstringWithSameHeadTail l = new LongestSubstringWithSameHeadTail();
        System.out.println(l.findMaxLength(s));
    }
}
