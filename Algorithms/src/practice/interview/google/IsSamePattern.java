package practice.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断两个pattern是否一致。比如【a,b,b,a】 和【c,d,d,c】是一致的,和【c,d,c,d】就不一致
 */
public class IsSamePattern {
    public boolean isSamePattern(String a, String b) {
        Map<Character, Character> map = new HashMap<>();
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (map.containsKey(ca)) {
                if (map.get(ca) != cb) return false;
            } else {
                if (map.values().contains(cb)) return false;
                map.put(ca, cb);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abba";
        String b = "ccdc";
        IsSamePattern i = new IsSamePattern();
        System.out.println(i.isSamePattern(a, b));
    }
}
