package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @string
 * @search
 *
 * Input: stamp = "abc", target = "ababc", Output: [0,2]
 * Input: stamp = "abca", target = "aabcaca", Output: [3,0,1]
 *
 * the last one must be the stamp, and overlaps all the existing chars
 * abca a(abca)ca - a****ca *****ca *******
 * a star can match any character
 * keep matching and replace chars with * until all the chars are stars
 */
public class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        char[] t = new char[target.length()];
        Arrays.fill(t, '*');
        char[] cur = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        while (!Arrays.equals(cur, t)) {
            int pos = matchAndReplace(cur, stamp);
            if (pos < 0) {
                return new int[]{};
            }
            res.add(pos);
        }
        int[] arr = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) {
            arr[res.size() - 1 - i] = res.get(i);
        }
        return arr;
    }

    private int matchAndReplace(char[] cur, String stamp) {
        for (int i = 0; i <= cur.length - stamp.length(); i++) {
            int j = i, k = 0;
            boolean allStars = true;
            while (k < stamp.length() && (stamp.charAt(k) == cur[j] || cur[j] == '*')) {
                if (cur[j] != '*') allStars = false;
                j++;
                k++;
            }
            if (k == stamp.length() && !allStars) {
                for (int m = 0; m < stamp.length() ; m++) {
                    cur[i + m] = '*';
                }
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StampingTheSequence s = new StampingTheSequence();
        System.out.println(s.movesToStamp("abca", "aabcaca"));
    }
}
