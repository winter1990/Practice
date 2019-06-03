package practice.leetcode.medium;

/**
 * @array
 *
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging
 * from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an],
 * then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * If there are multiple answers, print any of them.
 *
 * n = 6, k = 3
 * 1 2 3 4 5 6
 * 1 6 2 5 3 4, it has the most different values which is 5
 *
 * conclusion
 *   if we have [1, n], maximal distinct abs() is n-1
 *   we need k distinct, use k numbers to generate k-1 distinct and use the rest to generate 1
 * two pointers
 *   left = n - k, right = n
 *   fill in [1, left) into result
 *   start arranging left and right
 *     while (left <= right) the order is: left - right - left++ - right--
 *
 *
 */
public class BeautifulArrangement_II {
    public int[] constructArray1(int n, int k) {
        int[] res = new int[n];
        int left = n - k, right = n;
        int index = 0;
        while (index < left - 1) {
            res[index] = index + 1;
            index++;
        }
        while (left <= right) {
            if (left == right) {
                res[index] = left;
                break;
            }
            res[index] = left++;
            res[index + 1] = right--;
            index += 2;
        }
        return res;
    }

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;
        for (int i = 0; i < n; i++) {
            res[i] = k % 2 != 0 ? left++ : right--;
            if (k > 1) {
                k--;
            }
        }
        return res;
    }
}
