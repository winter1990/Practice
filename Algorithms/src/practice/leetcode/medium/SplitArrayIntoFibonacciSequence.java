package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 * @backtracking
 *
 * Input: "123456579", Output: [123,456,579]
 * Input: "11235813", Output: [1,1,2,3,5,8,13]
 * Input: "112358130", Output: []
 * Input: "0123", Output: []
 *
 * problems to solve:
 * 1. recursively get substring, start from 0
 * 2. skip leading 0
 * 3. previous two number sum up = current number
 */
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(S, 0, res);
        return res;
    }

    private boolean helper(String s, int index, List<Integer> res) {
        if (index == s.length() && res.size() >= 3) return true;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0' && i > index) break;
            long num = Long.valueOf(s.substring(index, i + 1));
            if (num > Integer.MAX_VALUE) break;
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) break;
            if (res.size() < 2 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add((int) num);
                if (helper(s, i + 1, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
