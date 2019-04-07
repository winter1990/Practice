package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 * @slidingwindow
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *   Add one piece of fruit from this tree to your baskets. If you cannot, stop.
 *   Move to the next tree to the right of the current tree. If there is no tree to the right, stop.
 *   Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2,
 *   then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type
 * of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 * 0 <= tree[i] < tree.length
 *
 * we maintain an interval, in this interval, we want to maximize the size that within it, there are at most 2 fruits
 * sliding window with at most two numbers in the window
 *         0 1 2 3 4 5 6 7 8 9 10
 * Input: [3,3,3,1,2,1,1,2,3,3,4] Output: 5
 * use map to count and two pointers (0,0)
 * most the right pointer, until map size 3, then move left pointer until frequency is 0
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int last = 0, res = 0;
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[last], map.get(tree[last]) - 1);
                if (map.get(tree[last]) == 0) map.remove(tree[last]);
                last++;
            }
            res = Math.max(res, i - last + 1);
        }
        return res;
    }

    public int totalFruit1(int[] tree) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  tree) {
            cur = (c == a || c == b) ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }
}
