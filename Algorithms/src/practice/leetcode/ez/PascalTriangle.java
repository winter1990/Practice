package practice.leetcode.ez;

/**
 * which subset and which index
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
            int j = 1;
            while (j < i) {
                int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                list.add(val);
                j++;
            }
            list.add(1);
            res.add(new LinkedList<>(list));
        }
        return res;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        int i = 5;
        System.out.println(pt.generate(i));
    }
}
