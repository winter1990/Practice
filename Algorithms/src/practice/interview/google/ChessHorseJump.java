package practice.interview.google;

import java.util.HashSet;
import java.util.Set;

/**
 * in a chess game,
 * 1. the board is infinite
 * 2. there are barriers
 * 3. if the horse can beat a give stone
 *
 * assume horse at (0,0) and target at (x,y)
 * horse can go 8 different directions
 * one way search will be infinite if target is surrounded with stones
 * use bi-directional search
 *   if the next move for each other is in the other set - true
 */
public class ChessHorseJump {
    int[][] dirs = {{1, 2}, {-1, 2}, {-1, -2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1}};
    public boolean canBeat(int[] target, int[][] stones) {
        Set<String> obstacles = new HashSet<>();
        for (int[] stone : stones) obstacles.add(stone[0] + " " + stone[1]);
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(0 + " " + 0);
        endSet.add(target[0] + " " + target[1]);
        Set<String> visited = new HashSet<>();
        while (!startSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> set = new HashSet<>();
            for (String next : startSet) {
                visited.add(next);
                String[] strs = next.split(" ");
                int x = Integer.valueOf(strs[0]);
                int y = Integer.valueOf(strs[1]);
                for (int[] d : dirs) {
                    int a = x + d[0];
                    int b = y + d[1];
                    String s = a + " " + b;
                    if (startSet.contains(s) || visited.contains(s) || obstacles.contains(s)) continue;
                    if (endSet.contains(s)) return true;
                    set.add(s);
                }
            }
            startSet = set;
        }
        return false;
    }

    public static void main(String[] args) {
        ChessHorseJump c = new ChessHorseJump();
        int[][] ob = {{1, 2}, {-1, 2}, {-1, -2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1}};
        System.out.println(c.canBeat(new int[]{1,1}, ob));
    }
}
