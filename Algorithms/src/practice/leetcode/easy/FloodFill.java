package practice.leetcode.easy;

/**
 * @dfs
 *
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535]
 *
 * recursively traverse the adjacent elements, if the current value = target value, change it to new value
 * -> (matrix, x, y, old value, new value)
 * up, down, left, right -> check boundary before going to next recursively
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] a, int r, int c, int old, int newColor) {
        if (r < 0 || r >= a.length || c < 0 || c >= a[0].length || a[r][c] != old || a[r][c] == newColor) {
            return;
        }
        a[r][c] = newColor;
        dfs(a, r - 1, c, old, newColor);
        dfs(a, r + 1, c, old, newColor);
        dfs(a, r, c - 1, old, newColor);
        dfs(a, r, c + 1, old, newColor);
    }
}
