package practice.leetcode.easy;

/**
 * @string
 * @math
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.
 * The robot can receive one of three instructions:
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degrees to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 *
 * problems to solve:
 * how to determine whether there is a circle
 *
 * if circle exists:
 *   back to some points at the end
 *   facing the same direction? not required, because eventually it will be facing north
 * to go back to the original position, the sum of horizontal and vertical should be 0
 */
public class RobotBoundedInCircle {
    final int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return true;
        int d = 0;
        int[] pos = new int[]{0, 0};
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                pos[0] += dirs[d][0];
                pos[1] += dirs[d][1];
            } else if (c == 'L') {
                d = (d + 3) % 4;
            } else if (c == 'R'){
                d = (d + 5) % 4;
            }
        }
        return (pos[0] == 0 && pos[1] == 0) || d != 0;
    }
}
