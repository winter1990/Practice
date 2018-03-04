package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * to make sure first player win
 * +- does not matter
 * ++ win
 * +++ win
 * ++++ win
 * +++++ lose
 * ++++++ win
 */
public class FlipGame_II {
    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    private boolean helper(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i <s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        FlipGame_II fg = new FlipGame_II();
        System.out.println(fg.canWin("++++"));
    }
}
