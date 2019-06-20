package practice.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 有一个整形数组，要分成五个五个一组，每组里面的元素都是以1为等差递增
 *
 *
 */
public class DivideNumbersIntoTwoEqualDifferenceSequence {
    public List<List<Integer>> divideArray(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length % 5 != 0) return res;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        while (map.size() > 0) {
            int start = map.firstKey();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= 4; i++) {
                int next = start + i;
                if (map.containsKey(next)) {
                    list.add(next);
                    map.put(next, map.get(next) - 1);
                } else {
                    break;
                }
                if (map.get(next) == 0) map.remove(next);
            }
            if (list.size() == 5) {
                res.add(list);
            } else {
                return new ArrayList<>();
            }
        }
        return res;
    }

    // 1 2 3 3 4 4 5 5 6 7
    // 1 1 1 2 2 2...5 5 5
    public List<List<Integer>> divideArray1(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length % 5 != 0) return res;
        Arrays.sort(arr);
        int l = 0;
        for (int i = 0; i < arr.length / 5; i++) {
            List<Integer> list = new ArrayList<>();
            int start = arr[l];
            int r = l;
            for (int j = 0; j <= 4; j++) {
                int t = start + j;
                while (r < arr.length && arr[r] != t) r++;
                if (r < arr.length) {
                    list.add(arr[r]);
                    arr[r] = -1;
                    r++;
                }
            }
            if (list.size() == 5) {
                res.add(list);
            } else {
                return new ArrayList<>();
            }
            while (l < arr.length && arr[l] == -1) l++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] in = {1,2,3,4,5,3,4,5,6,7,5,6,7,8,9};
        DivideNumbersIntoTwoEqualDifferenceSequence d = new DivideNumbersIntoTwoEqualDifferenceSequence();
        System.out.println(d.divideArray(in));
        System.out.println(d.divideArray1(in));
    }
}
