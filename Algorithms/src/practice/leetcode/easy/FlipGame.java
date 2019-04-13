package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() <= 1) {
            return res;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '+' && cs[i] == cs[i + 1]) {
                flip(cs, i);
                res.add(new String(cs));
                flip(cs, i);
            }
        }
        return res;
    }

    private void flip(char[] cs, int i) {
        if (cs[i] == '+') {
            cs[i] = '-';
            cs[i + 1] = cs[i];
        } else if (cs[i] == '-') {
            cs[i] = '+';
            cs[i + 1] = cs[i];
        }
    }

    public static void main(String[] args) {
        String s = "++";
        FlipGame fg = new FlipGame();
        System.out.println(fg.generatePossibleNextMoves(s));
    }
}
