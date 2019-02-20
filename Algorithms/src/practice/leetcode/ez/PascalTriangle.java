package practice.leetcode.ez;

/**
 * @array
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle
 *
 * 1 is the only element in first row. first and last element are always 1
 * initialize the list with [1], when start the next level, create a new list and add 1
 * j = 1, j < last level.length
 *
 */

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows <= 0) {
            return res;
        }
        List<Integer> l = new LinkedList<>();
        l.add(1);
        res.add(l);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
