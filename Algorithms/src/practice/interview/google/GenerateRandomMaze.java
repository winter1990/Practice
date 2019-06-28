package practice.interview.google;

public class GenerateRandomMaze {
    public static void main(String[] args) {
        GenerateRandomMaze g = new GenerateRandomMaze();
        int n = 31;
        int[][] res = g.maze(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] maze(int n) {
        // Assumptions: n = 2 * k + 1, where k > = 0.
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void generate(int[][] maze, int x, int y) {
        shuffle(dirs);
        for (int[] d: dirs) { // move two steps because we need to add wall between two path
            int nextX = x + 2 * d[0];
            int nextY = y + 2 * d[1];
            if (isValidMove(maze, nextX, nextY)) {
                maze[x + d[0]][y + d[1]] = 0;
                maze[nextX][nextY] = 0;
                generate(maze, nextX, nextY);
            }
        }
    }

    private void shuffle(int[][] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int)(Math.random() * (dirs.length - i));
            int[] tmp = dirs[i];
            dirs[i] = dirs[i + index];
            dirs[i + index] = tmp;
        }
    }

    private boolean isValidMove(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }

}
