package practice.interview;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * given height and width
 * generate a maze with ony one solution
 *
 * start (0,1),end with (m-1,n-2)
 *
 * define the path from start to end, store all the points
 * randomly choose points and add sub path
 * no intersection with solution path
 * 4 boarders are blocked
 */
public class GenerateMaze {
    Random rand = new Random();
    public int[][] generateMax(int m, int n) {
        int[][] maze = new int[m][n];
        Set<String> wall = new HashSet<>();
        generateWall(maze, wall, m, n);
        Set<String> sol = new HashSet<>();
        generateSolution(maze, sol, m, n);
        return null;
    }

    private void generateWall(int[][] maze, Set<String> wall, int m, int n) {
        for (int i = 0; i < m; i++) wall.add(i + " " + 0);
        for (int j = 2; j < n; j++) {
            wall.add(0 + " " + j);
            wall.add(m - 1 + " " + (n - j));
        }
    }

    private void generateSolution(int[][] maze, Set<String> sol, int m, int n) {

    }
}
