package practice.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumCount {
    public static int twoSumCount(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int a : arr) {
            if (set.contains(a)) {
                res.add(a < target - a ? a : target - a);
            } else {
                set.add(target - a);
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
//        int[] in = {1,7,2,5,3,5,4,4,16,2,6};
//        System.out.println(twoSumCount(in, 16));
        int[] in = {2,5,2,1,6,2,5};
        System.out.println(count(in, 7));
    }

    // follow up - different index means different combination
    // [2 5 2 6 5 2] target = 7, [0 1][1 2][0 4][2 4][1 5][4 5]
    public static int count(int[] arr, int target) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(target - a)) {
                res += map.get(target - a);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return res;
    }
}
