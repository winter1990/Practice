package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @math
 *
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 *     1      2
 *    / \    / \
 *   0...9  0...9
 *  /
 * 0...9...
 *
 * start from first layer
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) dfs(i, n, res);
        return res;
    }

    private void dfs(int v, int n, List<Integer> res) {
        if (v > n) return;
        res.add(v);
        for (int i = 0; i <= 9; i++) {
            if (v * 10 + i > n) return;
            dfs(v * 10 + i, n, res);
        }
    }

    // 1 10 100 101 102 ... 11 110 111 112...
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int v = 1;
        for (int i = 1; i < n; i++) {
            if (v * 10 <= n) {
                v *= 10;
            } else {
                while (v % 10 == 9 || v == n) v /= 10;
                v += 1;
            }
            res.add(v);
        }
        return res;
    }

    public static void main(String[] args) {
        LexicographicalNumbers l = new LexicographicalNumbers();
        System.out.println(l.lexicalOrder1(13));
    }
}
