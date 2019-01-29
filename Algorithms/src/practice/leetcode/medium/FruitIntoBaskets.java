package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int i = 0;
        for (int j = 0; j < tree.length; j++) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) {
                    map.remove(tree[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
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
