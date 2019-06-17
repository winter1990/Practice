package practice.interview;

import java.util.HashSet;
import java.util.Set;

public class FirstSecondLargestSmallestInKSortedArray {
    public int[] find(int[][] arr) {
        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
        for (int[] a : arr) {
            if (a.length == 0) continue;
            int l = a[a.length - 1], s = a[0];
            if (l > l1) {
                l2 = l1;
                l1 = l;
            } else if (l > l2) {
                l2 = l;
            }
            if (s < s1) {
                s2 = s1;
                s1 = s;
            } else if (s < s2) {
                s2 = s;
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        set.add(s1);
        set.add(s2);
        if (s1 != Integer.MAX_VALUE && s2 != Integer.MAX_VALUE && l1 != Integer.MIN_VALUE && l2 != Integer.MAX_VALUE) {
            return new int[]{l1, l2, s1, s2};
        }
        return new int[0];
    }
}
