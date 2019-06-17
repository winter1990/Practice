package practice.interview.google;

import java.util.*;

/**
 * sort好的数组， 最少三个连续， 能不能返回数组里的数， 分开之后都是连续的。比如 {1 2 3 3 4 5 6}可以变成{1 2 3} 和{3 4 5}
 */
public class MultipleThreeContinuousElements {
    public List<List<Integer>> getContinuousThree(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (map.containsKey(arr[i] + 1) && map.containsKey(arr[i] + 2) && map.get(arr[i] + 1) > 0 && map.get(arr[i] + 2) > 0) {
                List<Integer> list = new ArrayList<>();
                list.addAll(Arrays.asList(arr[i], arr[i] + 1, arr[i] + 2));
                res.add(list);
                map.put(arr[i], map.get(arr[i]) - 1);
                map.put(arr[i] + 1, map.get(arr[i] + 1) - 1);
                map.put(arr[i] + 2, map.get(arr[i] + 2) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MultipleThreeContinuousElements m = new MultipleThreeContinuousElements();
        System.out.println(m.getContinuousThree(new int[]{1,2,4,5,5,6,6,7,9,10,11,12}));
    }
}
