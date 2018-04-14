package practice.leetcode.medium;

/**
 * @array
 *
 * Suppose this list is [a1, a2, a3, ... , an],
 * then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 *
 * 1 2 3 4 5 6
 * 1 6 2 5 3 4, it has the most different values which is 5
 * k=3 1 2 3 6 4 5 => 1 1 3 2 1, l=3
 */
public class BeautifulArrangement_II {
    public int[] constructArray1(int n, int k) {
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

    public int[] constructArray2(int n, int k) {
        int[] res = new int[n];
        int l = 1;
        int h = n;
        l += (n - 1 - k);
        int index = 0;
        while (index < l - 1) {
            res[index] = index + 1;
            index++;
        }
        while (l <= h) {
            if (l == h) {
                res[index] = l;
                break;
            }
            res[index] = l;
            res[index + 1] = h;
            l++;
            h--;
            index += 2;
        }
        return res;
    }
}
