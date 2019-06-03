package practice.leetcode.medium;

/**
 * @array
 *
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.
 * A black lonely pixel is character 'B' that located at a specific position where the same row and same column
 * don't have any other black pixels.
 *
 * brute force
 * scan through the 2d array
 * if black, then search row and column - time consuming
 * same row and column might be checked multiple times if multiple black pixel in same row/col
 *
 * count the black pixels for each row and column separately
 * another pass to check, then count
 */
public class LonelyPixel_I {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
