package practice.leetcode.question;

/**
 * @dfs
 * @graph In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.
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
    int count, n;
    int[] f;

    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        f = new int[n * n * 4];
        count = n * n * 4;
        for (int i = 0; i < n * n * 4; ++i) {
            f[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
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
