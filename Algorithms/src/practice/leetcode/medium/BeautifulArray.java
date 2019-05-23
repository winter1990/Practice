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
 * properties of beautiful array:
 *   a[k]*2 != a[i]+a[j], i<k<j
 *
 * core idea:
 * build up the beautiful array from one single element
 * increase the number of element in the result set
 *
 * if it is beautiful:
 *   addition: (a[k]+x)*2 = a[k]+2x != (a[i]+x)+(a[j]+x) -> the property still true
 *   multiplication: x*(a[k]*2) != x*a[i]+x*a[j] -> the property still true
 * based on above
 *
 * a = [1 3 2]
 * a1 = 2*a-1 = [1 5 3]
 * a2 = 2*a = [2 6 4]
 * result = a1 + a2 = [1 5 3 | 2 6 4]
 * left half and right half are both beautiful
 * a[k] * 2 = even
 * a[i] and a[j] are
 *   both in left half -> proved
 *   both in right half -> proved
 *   one in left one in right -> odd+even must be odd, and a[k] * 2 must be even -> proved
 *
 * 1
 * 1 2
 * 1 3 2 4
 * 1 5 3 7 2 6 4 8
 */
public class BeautifulArray {
    public int[] beautifulArray(int N) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : list) {
                if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            }
            for (int i : list) {
                if (i * 2 <= N) tmp.add(i * 2);
            }
            list = tmp;
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) res[i] = list.get(i);
        return res;
    }
}
