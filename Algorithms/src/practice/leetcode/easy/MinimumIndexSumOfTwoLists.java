package practice.leetcode.easy;

import java.util.*;

/**
 * a b c d
 * e f b c
 * output b
 *
 * a b c d
 * d c b a
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length == 0 && list2.length == 0) {
            return new String[0];
        } else if (list1.length == 0 || list2.length == 0) {
            return new String[0];
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            int j = map.getOrDefault(list2[i], -1);
            if (j != -1 && i + j <= minSum) {
                if (i + j < minSum) {
                    res = new ArrayList<>();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists m = new MinimumIndexSumOfTwoLists();
        String[] s1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] s2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        System.out.println(m.findRestaurant(s1,s2));
    }
}
