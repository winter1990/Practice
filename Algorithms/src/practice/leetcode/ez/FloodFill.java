package practice.leetcode.ez;

/**
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535]
 *
 * dfs
 */
public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fillColor(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static void fillColor(int[][] image, int i, int j, int newVal, int val) {
        if (image[i][j] == val) {
            image[i][j] = newVal;
            if (i >= 1) { // up
                fillColor(image, i - 1, j, newVal, val);
            }
            if (i < image.length - 1) { // down
                fillColor(image, i + 1, j, newVal, val);
            }
            if (j >= 1) { //left
                fillColor(image, i, j - 1, newVal, val);
            }
            if (j < image[0].length - 1) { // right
                fillColor(image, i, j + 1, newVal, val);
            }
        }

    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
