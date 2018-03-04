package practice.leetcode.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Flatten2DVector {
}

class Vector2D implements Iterator<Integer> {
    int row;
    int col;
    Integer res;
    List<List<Integer>> list;
    public Vector2D(List<List<Integer>> vec2d) {
        row = 0;
        col = 0;
        list = vec2d;
        res = null;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            res = list.get(row).get(col);
            col++;
        }
        if (col == list.get(row).size()) {
            row++;
            col = 0;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if (row < list.size() && list.get(row).size() == 0) {
            row++;
            col = 0;
        }
        if (row < list.size() && col < list.get(row).size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> in = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();
        /*
        l1.add(1);l1.add(2);l1.add(3);
        l2.add(4);
        l3.add(5);l3.add(6);
        in.add(l1);
        in.add(l2);
        in.add(l3);
        */
        l2.add(3);
        in.add(l1);
        in.add(l2);
        Vector2D v =new Vector2D(in);
        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }
}