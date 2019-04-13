package practice.leetcode.easy;

import java.util.*;

public class IntersectionOfTwoArrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        for (int i : nums1) {
            if (!map1.containsKey(i)) {
                map1.put(i, 1);
            } else {
                map1.put(i, map1.get(i) + 1);
            }
        }
        for (int i : nums2) {
            if (map1.containsKey(i) && map1.get(i) > 0) {
                list.add(i);
                map1.put(i, map1.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            res[i] = it.next();
            i++;
        }
        return res;
    }
}
