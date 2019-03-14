package practice.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:
 * For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
 * Input: 4, Output: [2,1,4,3]
 * Input: 5, Output: [3,1,2,5,4]
 *
 * pick any number between [1,n-2], a[k] * 2 = a[i] + a[j], i < k < j
 * we can apply the changes of a beautiful array, to get a new beautiful array
 * addition
 * [1 3 2] + 1 = [2 4 3]
 * multiplication
 * [1 3 2] * 2 = [2 6 4]
 * if we have an array with length N
 * A1 = A * 2 - 1 is beautiful with only odds from 1 to N * 2 -1
 * A2 = A * 2 is beautiful with only even from 2 to N * 2
 * B = A1 + A2 beautiful array with length N * 2
 * A = [2, 1, 4, 5, 3]
 * A1 = [3, 1, 7, 9, 5]
 * A2 = [4, 2, 8, 10, 6]
 * B = A1 + A2 = [3, 1, 7, 9, 5, 4, 2, 8, 10, 6]
 */
public class BeautifulArray {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : res) {
                if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            }
            for (int i : res) {
                if (i * 2 <= N) tmp.add((i * 2));
            }
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
