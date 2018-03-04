package practice.leetcode.medium;

import java.util.*;

public class StrobogrammaticNumber_II {
    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return helper(n, n);
    }

    private List<String> helper(int m, int n) {
        if (m == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (m == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = helper(m - 2, n);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (m != n) {
                res.add("0" + str + "0");
            }
            res.add("6" + str + "9");
            res.add("9" + str + "6");
            res.add("1" + str + "1");
            res.add("8" + str + "8");
        }
        return res;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber_II sn = new StrobogrammaticNumber_II();
        System.out.println(sn.findStrobogrammatic(3));

    }
}
