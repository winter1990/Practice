package practice.leetcode.medium;

/**
 * @dfs
 * @graph
 * @unionfind
 *
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.
 * These characters divide the square into contiguous regions.
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * <p>
 * https://leetcode.com/problems/regions-cut-by-slashes/discuss/205680/JavaC%2B%2BPython-Split-4-parts-and-Union-Find
 * <p>
 * Split a cell in to 4 parts
 * ------
 * | \ /|
 * | / \|
 * ------
 * Two adjacent parts in different cells are contiguous regions.
 * In case '/', top and left are contiguous, botton and right are contiguous.
 * In case '\\', top and right are contiguous, bottom and left are contiguous.
 * In case ' ', all 4 parts are contiguous.
 */
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] image = new boolean[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    image[3 * i][3 * j + 2] = true;
                    image[3 * i + 1][3 * j + 1] = true;
                    image[3 * i + 2][3 * j] = true;
                } else if (c == '\\') {
                    image[3 * i][3 * j] = true;
                    image[3 * i + 1][3 * j + 1] = true;
                    image[3 * i + 2][3 * j + 2] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (!image[i][j]) {
                    res++;
                    dfs(image, i, j, n);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RegionsCutBySlashes r = new RegionsCutBySlashes();
        String[] g = {" /","/ "};
        System.out.println(r.regionsBySlashes(g));
    }

    private void dfs(boolean[][] image, int i, int j, int n) {
        if (i < 0 || i >= 3 * n || j < 0 || j >= 3 * n || image[i][j]) return;
        image[i][j] = true;
        dfs(image, i + 1, j, n);
        dfs(image, i - 1, j, n);
        dfs(image, i, j + 1, n);
        dfs(image, i, j - 1, n);
    }

    int count, n;
    int[] f;
    public int regionsBySlashes1(String[] grid) {
        n = grid.length;
        f = new int[n * n * 4];
        count = n * n * 4;
        for (int i = 0; i < n * n * 4; i++) f[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    union(g(i - 1, j, 2), g(i, j, 0));
                }
                if (j > 0) {
                    union(g(i, j - 1, 1), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 2), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    union(g(i, j, 0), g(i, j, 3));
                    union(g(i, j, 2), g(i, j, 1));
                }
            }
        }
        return count;
    }

    public int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f[x] = y;
            count--;
        }
    }

    public int g(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }
}
