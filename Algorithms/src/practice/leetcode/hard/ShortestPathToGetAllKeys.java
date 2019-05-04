package practice.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @array
 * @search
 *
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...)
 * are keys, and ("A", "B", ...) are locks.
 * If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 * Return the lowest number of moves to acquire all keys.
 * If it's impossible, return -1.
 *
 * "@ . a . #",
 * "# # # . #",
 * "b . A . B"
 * Output: 8
 *
 * "@ . . a A",
 * ". . B # .",
 * ". . . . b"
 * Output: 6
 *
 * problems to solve:
 * 1. need to pick up all keys
 * 2. after collecting the key(s) we can walk on the lock
 * 3. minimize the total distance
 * 4. the order to pick up the key matters
 *
 * scan once to get total number of keys and the start point
 * need to use another class to keep track of:
 *   the (i,j)
 *   need to track which key is collected - because [a,f] so one integer is enough, like a mask
 * handle the visited point for DIFFERENT PATHS - "x y key"
 */
public class ShortestPathToGetAllKeys {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int si = -1, sj = -1, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                }
                if (isKey(c)) k++;
            }
        }
        Node start = new Node(si, sj, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(si + " " +  sj + " " + 0);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.key == (1 << k) - 1) return level;
                for (int[] d : dirs) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    int key = cur.key;
                    if (!isValid(grid, x, y, m, n)) continue;
                    char c = grid[x].charAt(y);
                    if (isKey(c)) key |= (1 << (c - 'a'));
                    if (isLock(c) && (key >> (c - 'A') & 1) == 0) continue;
                    if (visited.add(x + " " + y + " " + key)) q.offer(new Node(x, y, key));
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isValid(String[] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
    }

    class Node {
        int i, j, key;
        public Node(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
}
