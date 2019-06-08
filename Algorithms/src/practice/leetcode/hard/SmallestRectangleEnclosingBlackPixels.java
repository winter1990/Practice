package practice.leetcode.hard;

/**
 * @array
 *
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle
 * that encloses all black pixels.
 *
 * Input:
 * [
 *   "0010",
 *   "0110",
 *   "0100"
 * ]
 * x = 0, y = 2, Output: 6
 *
 * brute force
 * linear search the matrix and get the min and max in horizontal and vertical directions
 *
 * optimization
 * if we are given one black pixel
 * the project to bottom must be 0...01...10...0 because all black pixels are connected
 * so search left and right from y
 * search the up and down from x
 *
 * O(mlogn+nlogm)
 */
public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int l = searchLeft(image, 0, y, true);
        int r = searchRight(image, y, n - 1, true);
        int u = searchLeft(image,0, x, false);
        int d = searchRight(image, x, m - 1, false);
        return (r - l + 1) * (d - u + 1);
    }

    private int searchRight(char[][] image, int l, int r, boolean isHorizontal) {
        int s = l, e = r;
        while (s < e) {
            int mid = s + (e - s + 1) / 2;
            if (isAllWhite(image, mid, isHorizontal)) {
                e = mid - 1;
            } else {
                s = mid;
            }
        }
        return r;

    }

    private int searchLeft(char[][] image, int l, int r, boolean isHorizontal) {
        int s = l, e = r;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (isAllWhite(image, mid, isHorizontal)) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    private boolean isAllWhite(char[][] image, int mid, boolean isHorizontal) {
        if (isHorizontal) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    return false;
                }
            }
            return true;
        } else {
            for (int j = 0; j < image[0].length; j++) {
                if (image[mid][j] == '1') {
                    return false;
                }
            }
            return true;
        }
    }

    public int minArea1(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        int m = image.length, n = image[0].length;
        int l = n, r = -1, u = n, d = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == '1') {
                    l = Math.min(l, j);
                    r = Math.max(r, j);
                    u = Math.min(u, i);
                    d = Math.max(d, i);
                }
            }
        }
        return (r - l + 1) * (d - u + 1);
    }

    public static void main(String[] args) {
        SmallestRectangleEnclosingBlackPixels s = new SmallestRectangleEnclosingBlackPixels();
        char[][] cs = {{'0','0','1','0'}, {'0','1','1','0'},{'0','1','0','0'}};
        System.out.println(s.minArea1(cs, 0,2));
    }
}
