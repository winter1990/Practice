package practice.leetcode.medium;

import java.util.Arrays;

/**
 * A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each
 * [3, 0, 6, 1, 5] -> 3
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * 0 1 3 5 6
 * 5 4 3 2 1
 *
 * 0 1 4 5 6
 * 5 4 3 2 1
 *
 * 10 12
 *
 */
public class HIndex {
    //
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                arr[n] += 1;
            } else {
                arr[citations[i]] += 1;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += arr[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    // sorting
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        } else if (citations.length == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        int i;
        for (i = 0; i < n; i++) {
            if ((i == 0 && citations[0] >= n - i) || (citations[i] >= n - i && (n - i >= citations[i - 1]))) {
                break;
            }
        }
        return n - i;
    }
}
