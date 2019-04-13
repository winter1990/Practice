package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) | m) == num) {
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 | 2);
        System.out.println(1 | 1);
        System.out.println(1 ^ 1);
    }
}
