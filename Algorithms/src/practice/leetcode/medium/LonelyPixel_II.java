package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels
 * located at some specific row R and column C that align with all the following rules:
 *   1. Row R and column C both contain exactly N black pixels.
 *   2. For all rows that have a black pixel at column C, they should be exactly the same as row R
 *
 * Input:
 * [['W', 'B', 'W', 'B', 'B', 'W'],
 *  ['W', 'B', 'W', 'B', 'B', 'W'],
 *  ['W', 'B', 'W', 'B', 'B', 'W'],
 *  ['W', 'W', 'B', 'W', 'B', 'W']]
 *
 * N = 3
 * Output: 6
 *
 * problems to solve:
 * 1. count # of black pixels per row and col
 * 2. group the same rows
 *
 * to count the pixels for row and column
 * map<string, int>
 */
public class LonelyPixel_II {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length, n = picture[0].length;
        Map<String, Integer> map = new HashMap<>();
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            String key = getRowKey(picture, i, N, col);
            if (key.length() != 0) map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int i = 0; i < key.length(); i++) {
                    if (key.charAt(i) == 'B' && col[i] == N) res += map.get(key);
                }
            }
        }
        return res;
    }

    private String getRowKey(char[][] a, int i, int N, int[] col) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int j = 0; j < a[0].length; j++) {
            sb.append(a[i][j]);
            if (a[i][j] == 'B') {
                count++;
                col[j]++;
            }
        }
        return count == N ? sb.toString() : "";
    }

    public static void main(String[] args) {
        LonelyPixel_II l = new LonelyPixel_II();
        char[][] in = {{'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {     'W', 'B', 'W', 'B', 'B', 'W'},
                {     'W', 'W', 'B', 'W', 'B', 'W'}};
        System.out.println(l.findBlackPixel(in, 3));
    }
}
