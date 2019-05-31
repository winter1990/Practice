package practice.interview.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * in a chess game,
 * 1. the board is infinite
 * 2. there are barriers
 * 3. if the horse can beat a give stone
 *
 * 2  121
 *  212321
 * 2 23032
 *  21 321
 * 2  121
 *  2 2 2
 *
 * assume horse at (0,0) and target at (x,y)
 * horse can go 8 different directions
 * one way search will be infinite if target is surrounded with stones
 * use bi-directional search
 *   if the next move for each other is in the other set - true
 */
public class ChessHorseJump {
    int[][] dirs1 = {{1, 2}, {-1, 2}, {-1, -2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1}};
    int[][] dirs2 = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int MAX_LEVEL;
    public boolean canReach(int[] target, int[][] stones) {
        return false;
    }

    public boolean canBeat(int[] target, int[][] stones) {
        int x = target[0], y = target[1];
        Set<String> obstacles = new HashSet<>();
        for (int[] s : stones) obstacles.add(s[0] + " " + s[1]);
        String end = x + " " + y;
        MAX_LEVEL = 3 * (x + y);
        int level = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            ++level;
            if (level > MAX_LEVEL) return false;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (end.equals(cur[0] + " " + cur[1])) return true;
                for (int[] d : dirs1) {
                    int a = cur[0] + d[0];
                    int b = cur[1] + d[1];
                    String next = a + " " + b;
                    if (!obstacles.contains(next)) q.offer(new int[]{a, b});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ChessHorseJump c = new ChessHorseJump();
        int[][] ob = {{2,1},{1,2},{-2,1},{-2,-1}};
        System.out.println(c.canBeat(new int[]{1,2}, ob));
    }
}
