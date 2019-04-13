package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        int[] res = new int[set2.size()];
        Iterator<Integer> it = set2.iterator();
        int i = 0;
        while (it.hasNext()) {
            res[i] = it.next();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2};
        int[] a2 = {2,1};
        IntersectionOfTwoArrays a = new IntersectionOfTwoArrays();
        System.out.println(a.intersection(a1,a2));
    }
}
