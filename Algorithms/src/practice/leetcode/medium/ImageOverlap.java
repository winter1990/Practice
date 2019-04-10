package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @array
 *
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * output:3
 *
 * brute force:
 * initially, two images are completely overlapped, count
 * move up/down/left/right with [1,n-1] steps, for each step, count the overlapped 1s
 * if we fix A and move B:
 *   up, i + k
 *   down i - k
 *   left j + k
 *   right j - k
 *
 * optimization:
 * keep track of all the 1s for two images
 * put in separate lists
 * store p1[0]-p2[0] p1[1]-p2[1] and frequency -> map(string, integer)
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) la.add(new int[]{i, j});
                if (B[i][j] == 1) lb.add(new int[]{i, j});
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int[] a : la) {
            for (int[] b : lb) {
                String pos = (a[0] - b[0]) + " " + (a[1] - b[1]);
                map.put(pos, map.getOrDefault(pos, 0) + 1);
            }
        }
        int res = 0;
        for (int f : map.values()) res = Math.max(res, f);
        return res;
    }
}
