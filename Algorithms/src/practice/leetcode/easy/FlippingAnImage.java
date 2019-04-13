package practice.leetcode.easy;

/**
 * @array
 *
 * brute force:
 * two pointers - swap[i,j] O(N), then revert O(N)
 *
 * 4 cases:
 * 1,0 -> 0,1 -> 1,0    not changed
 * 0,1 -> 1,0 -> 0,1    not changed
 * 1,1 -> 1,1 -> 0,0    flip both
 * 0,0 -> 0,0 -> 1,1    flip both
 * element in the middle
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            int l = 0, r = row.length - 1;
            while (l < r) {
                if (row[l] == row[r]) {
                    row[l] = row[l] == 0 ? 1 : 0;
                    row[r] = row[r] == 0 ? 1 : 0;
                }
                l++;
                r--;
            }
            if (l == r) {
                row[l] = row[l] == 0 ? 1 : 0;
            }
        }
        return A;
    }

    public int[][] flipAndInvertImage1(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < n; i++) {
                if (row[i] == row[n - i - 1]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }
        return A;
    }
}
