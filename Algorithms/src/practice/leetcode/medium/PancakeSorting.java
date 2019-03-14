package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @sort
 *
 * Input: [3,2,4,1], Output: [4,2,4,3]
 * 3 2 4 1 -> 1 4 2 3 -> 4 1 2 3 -> 3 2 1 4 -> 1 2 3 4
 *
 * in term of sort, we can start with thinking of smallest or largest
 * as the result, all numbers should be in increasing order
 * when we sort, we reverse all the first k, so deal with largest number first
 * 3241 3 -> 4231 4 -> 1324 2 -> 3124 3 -> 2134 2 -> 1234
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i : A) list.add(i);
        Collections.sort(list);
        List<Integer> res = new ArrayList<>();
        int offset = 0, n = A.length;
        while (list.size() != 0) {
            int i = 0;
            while (A[i] != list.get(list.size() - 1)) i++;
            if (i != 0) {
                reverse(A, 0, i);
                res.add(i + 1);
            }
            if (offset != n - 1) {
                reverse(A, 0, n - 1 - offset);
                res.add(n - offset);
            }
            offset++;
            list.remove(list.size() - 1);
        }
        return res;
    }

    private void reverse(int[] a, int s, int e) {
        while (s < e) {
            int tmp = a[s];
            a[s++] = a[e];
            a[e--] = tmp;
        }
    }

    /**
     * a more concise solution
     */
    public List<Integer> pancakeSort1(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
