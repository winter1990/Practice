package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(B[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(A[i]).get(0);
            map.get(A[i]).remove(0);
        }
        return res;
    }
}
