package practice.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @string
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * use a variable to track the last, and one pointer the walk through the string
 * count the sequence, when i != i-1, then check count if larger than 3, then add to list
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new LinkedList<>();
        if (S.length() < 3) {
            return res;
        }
        int i = 1;
        int count = 1;
        int last = 0;
        while (i < S.length()) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                count++;
            } else {
                if (i - last >= 3) {
                    List<Integer> list = Arrays.asList(last, i - 1);
                    res.add(list);
                }
                count = 1;
                last = i;
            }
            i++;
        }
        if (count >= 3) {
            res.add(Arrays.asList(last, i - 1));
        }
        return res;
    }

    public List<List<Integer>> largeGroupPositions1(String S) {
        int i = 0;
        int last = 0;
        int n = S.length();
        List<List<Integer>> res = new LinkedList<>();
        while (i < n) {
            while (i < n) {
                while (i < n && S.charAt(last) == S.charAt(i)) {
                    i++;
                }
                if (i - last >= 3) {
                    res.add(Arrays.asList(last, i - 1));
                }
                last = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abbxxxxzzy";
        PositionsOfLargeGroups po = new PositionsOfLargeGroups();
        System.out.println(po.largeGroupPositions(s));
    }
}
