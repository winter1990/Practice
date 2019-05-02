package practice.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @search
 *
 * In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
 * We start at the source square and want to reach the target square.
 * Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
 * Return true if and only if it is possible to reach the target square through a sequence of moves.
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 *
 */
public class EscapeALargeMaze {
    final int MAX_LEVEL = 20000;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> block = new HashSet<>();
        for (int[] b : blocked) block.add(b[0] + " " + b[1]);
        return canReach(block, source) && canReach(block, target);
    }

    private boolean canReach(Set<String> block, int[] src) {
        Set<String> visited = new HashSet<>();
        visited.add(src[0] + " " + src[1]);
        Queue<int[]> q = new LinkedList<>();
        q.offer(src);
        int level = 0, max = block.size();
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    String next = x + " " + y;
                    if (x >= 0 && x < 1e6 && y >= 0 && y < 1e6 && !visited.contains(next) && !block.contains(next)) {
                        visited.add(next);
                        q.add(new int[]{x, y});
                    }
                }
            }
            level++;
            if (level >= max) break;
            if (q.size() == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EscapeALargeMaze e = new EscapeALargeMaze();
//        System.out.println(e.isEscapePossible(new int[][]{{0,1},{1,0}}, new int[]{0,0}, new int[]{0,2}));
        System.out.println(e.isEscapePossible(new int[][]{}, new int[]{0,0}, new int[]{999999,999999}));
    }
}
