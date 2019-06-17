package practice.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an input string in the format String s = "" return
 * Expected output: [abcdfgh, abcdfij, abcefgh, abcefij]
 * This is exact output of echo abc{d,e}f{gh,ij} on a bash terminal
 *
 */
public class BraceExpansion {
    public List<String> getAllExpansion(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, "", res);
        return res;
    }

    private void dfs(String s, int start, String cur, List<String> res) {
        if (start == s.length()) {
            res.add(cur);
            return;
        }
        int left = s.indexOf('{', start);
        int right = s.indexOf('}', start);
        if (left == -1) {
            res.add(cur + s.substring(start));
            return;
        }
        String sub = s.substring(left + 1, right);
        String[] strs = sub.split(",");
        for (String str : strs) {
            dfs(s, right + 1, cur + s.substring(start, left) + str, res);
        }
    }

    public static void main(String[] args) {
        String s = "{x,y}abc{d,e}f{ij}s";
        BraceExpansion b = new BraceExpansion();
        System.out.println(b.getAllExpansion(s));
    }
}
