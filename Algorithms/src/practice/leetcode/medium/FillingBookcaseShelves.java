package practice.leetcode.medium;

/**
 * @array
 *
 * We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].
 *
 * We want to place these books in order onto bookcase shelves that have total width shelf_width.
 *
 *
 */
public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int m = books.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int w = books[i - 1][0];
            int h = books[i - 1][1];
            dp[i] = dp[i - 1] + h;
            for (int j = i - 1; j > 0 && w + books[j - 1][0] <= shelf_width; j--) {
                h = Math.max(h, books[j - 1][1]);
                w += books[j - 1][0];
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }
        return dp[m];
    }
}
