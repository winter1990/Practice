package practice.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        Set<String> hs = new HashSet<>();
        dfs(robot, 0, 0, 0, hs);
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public void dfs(Robot robot, int x, int y, int curDir, Set<String> visited) {
        visited.add(x + "#" + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4; //moving direction, let's say we are facing right (1), nextDir will be 1 as well.
            int nextX = x + dx[nextDir];
            int nextY = y + dy[nextDir];
            if (!visited.contains(nextX + "#" + nextY) && robot.move()) { //robot.move() not only checks wall but also moves
                dfs(robot, nextX, nextY, nextDir, visited);
                //go back to start cell
                robot.turnRight();
                robot.turnRight();
                robot.move();
                //go back to the original direction
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); //because we purposely arranged dx, dy to be clockwise. If we are facing right, we will be facing down in the next iteration
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