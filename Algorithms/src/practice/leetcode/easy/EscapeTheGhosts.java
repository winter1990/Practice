package practice.leetcode.easy;

/**
 * don't need to check all the ghosts
 * just check the ghosts in the rectangle (0, t[0], 0, t[1])
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int steps = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (steps <= distance) {
                return false;
            }
        }
        return true;
    }
}
