package practice.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class MergeKSortedArrayLists {
    public List<Integer> mergeLists(List<List<Integer>> lists) {
        return mergeSort(lists, 0, lists.size() - 1);
    }

    private List<Integer> mergeSort(List<List<Integer>> lists, int lo, int hi) {
        if (lo == hi) {
            return lists.get(lo);
        }
        int mid = lo + (hi - lo) / 2;
        List<Integer> list1 = mergeSort(lists, lo, mid);
        List<Integer> list2 = mergeSort(lists, mid + 1, hi);
        return merge(list1, list2);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> list = new LinkedList<>();
        int i1 = 0, i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1) < l2.get(i2)) {
                list.add(l1.get(i1));
                i1++;
            } else {
                list.add(l2.get(i2));
                i2++;
            }
        }
        while (i1 < l1.size()) list.add(l1.get(i1++));
        while (i2 < l2.size()) list.add(l2.get(i2++));
        return list;
    }

    public static void main(String[] args) {
        MergeKSortedArrayLists m = new MergeKSortedArrayLists();
        List<Integer> l1 = Arrays.asList(1,5,9,10,15);
        List<Integer> l2 = Arrays.asList(0,3,4);
        List<Integer> l3 = Arrays.asList(6,7,10);
        List<Integer> l4 = Arrays.asList(7,8,12);
        List<Integer> l5 = Arrays.asList(2,4);
        List<List<Integer>> in = Arrays.asList(l1,l2,l3,l4,l5);
        System.out.println(m.mergeLists(in));
    }
}
