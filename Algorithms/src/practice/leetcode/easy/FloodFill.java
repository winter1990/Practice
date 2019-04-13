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
 *
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fillColor(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void fillColor(int[][] image, int i, int j, int newVal, int val) {
        if (image[i][j] == val) {
            image[i][j] = newVal;
            if (i >= 1) fillColor(image, i - 1, j, newVal, val);
            if (i < image.length - 1) fillColor(image, i + 1, j, newVal, val);
            if (j >= 1) fillColor(image, i, j - 1, newVal, val);
            if (j < image[0].length - 1) fillColor(image, i, j + 1, newVal, val);
        }
    }
}
