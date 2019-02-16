package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @backtracking
 * @string
 *
 * Input: n = 3, k = 3, Output: "213"
 *
 * Input: n = 4, k = 9, Output: "2314"
 * 1    2    3    4    5    6    7    8    9    10   11   12
 * 1234 1243 1324 1342 1423 1432 2134 2143 2314 2341 2413 2431...
 * initially [1 2 3 4] [0 1 2 6 24], k-- = 9
 * [1 2 3 4] k=9, 9/6=1 pick second in list 2
 * [1 3 4]   k=9-6=3, 3/2=1 pick third 3
 * [1 3]     k=3-2=1, 1/1=1 pick second 3
 * [1]       k=1-1=0, 0/1=0 pick first 1
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k -= 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(list.get(index));
            list.remove(index);
            k -= index * fact[n - i];
        }
        return sb.toString();
    }
}
