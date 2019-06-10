package practice.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 *
 * 1 means accessible, 0 means block
 * searching method:
 * bfs - go to one cell, come back to original cell and then next. time complexity high
 * dfs - go to one direction first and clean all the cells in that direction, and then come back to original cell
 * the order of directions matter
 */
public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, 0, 0, 0, visited); // start at (0,0), direction - index 0 in dirs
    }

    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}}; // anti-clock wise
    public void dfs(Robot robot, int x, int y, int curDir, Set<String> visited) {
        String s = x + " " + y;
        if (visited.contains(s)) return;
        visited.add(s);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int nextX = x + dirs[curDir][0];
                int nextY = y + dirs[curDir][1];
                dfs(robot, nextX, nextY, curDir, visited);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            curDir = (curDir + 1) % 4;
        }
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}