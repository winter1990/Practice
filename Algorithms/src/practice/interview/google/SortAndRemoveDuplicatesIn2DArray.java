package practice.interview.google;

import java.util.*;

public class SortAndRemoveDuplicatesIn2DArray {
    public List<List<Integer>> sortAndRemove(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i][j - 1] && !set.contains(matrix[i][j - 1])) {
                    list.add(matrix[i][j - 1]);
                    set.add(matrix[i][j - 1]);
                }
            }
            list.add(matrix[i][n - 1]);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = {{3,2,2,3},{6,4,2,6},{1,2,3,6}};
        SortAndRemoveDuplicatesIn2DArray s = new SortAndRemoveDuplicatesIn2DArray();
        System.out.println(s.sortAndRemove(in));
    }
}
