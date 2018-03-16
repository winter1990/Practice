package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * what if there are duplicate numbers in the array
 */
public class TwoSum_II {
    public List<int[]> findTargetSum(int[] arr, int target) {
        List<int[]> res = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return res;
        }
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put((long) (target - arr[i]), list);
            } else {
                List<Integer> indexList = map.get(arr[i]);

                int[] subList = new int[2];
                subList[0] = indexList.get(0);
                subList[1] = i;
                indexList.remove(0);
                if (indexList.size() == 0) {
                    map.remove(arr[i]);
                }
                res.add(subList);
            }
        }
        return res;
    }

}
