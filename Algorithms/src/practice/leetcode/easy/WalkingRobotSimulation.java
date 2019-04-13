package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @array
 *
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 *
 * input:
 * steps is straight forward
 * for changing direction, initially [0,1],[1,0],[0,-1],[-1,0] need an index for direction
 * if turn right (-1), index++;
 * if turn left (-2), index--;
 * index = (updatedIndex + 4) % 4
 *
 * obstacle:
 * multiple in the line, choose nearest -> in this way we have to store [x,list[y1 y2...] and [y, list[x1 x2..] and sorted
 * store all the obstacles, concatenate x+y, x space y. put in the set
 * if we move n steps, for each step, depends on direction, check the next step whether it's in set
 *
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> ob = new HashSet<>();
        for (int[] obstacle : obstacles) ob.add(obstacle[0] + " " + obstacle[1]);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int d = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -1) {
                d = (d + 5) % 4;
            } else if (command == -2) {
                d = (d + 3) % 4;
            } else {
                int i = 1;
                while (i <= command) {
                    String next = (x + dirs[d][0] * i) + " " + (y + dirs[d][1] * i);
                    if (ob.contains(next)) {
                        break;
                    }
                    i++;
                }
                i -= 1;
                x += dirs[d][0] * i;
                y += dirs[d][1] * i;
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] c = new int[]{-2,-1,8,9,6};
        int[][] o = new int[][]{{-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}};
        WalkingRobotSimulation wr = new WalkingRobotSimulation();
        System.out.println(wr.robotSim(c, o));
    }
}
