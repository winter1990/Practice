package practice.leetcode.medium;

import java.util.*;

/**
 * @design
 *
 * Design a Snake game that is played on a device with screen size = width x height.
 *
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 *
 * You are given a list of food's positions in row-column order.
 * When a snake eats the food, its length and the game's score both increase by 1.
 *
 * initialize the board
 * a list of food & its index
 * a deque store all the positions of snake
 * a set to store the snake
 * final score
 */
public class DesignSnakeGame {
    static class SnakeGame {

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

        int[][] food;
        int foodIndex;
        int w;
        int h;
        int score;
        Set<String> set;
        LinkedList<Point> snake;
        public SnakeGame(int width, int height, int[][] food) {
            w = width;
            h = height;
            this.food = food;
            foodIndex = 0;
            score = 0;
            snake = new LinkedList<>();
            set = new HashSet<>();
            snake.add(new Point(0, 0));
            set.add(0 + " " + 0);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int x = snake.peek().row;
            int y = snake.peek().col;
            if (direction.equals("U")) {
                x--;
            } else if (direction.equals("D")) {
                x++;
            } else if (direction.equals("L")) {
                y--;
            } else if (direction.equals("R")) {
                y++;
            }
            if (x < 0 || x >= h || y < 0 || y >= w) return -1;
            if (foodIndex < food.length && x == food[foodIndex][0] && y == food[foodIndex][1]) {
                foodIndex++;
                score++;
            } else {
                set.remove(snake.getLast().row + " " + snake.getLast().col);
                snake.removeLast();
            }
            if (!set.add(x + " " + y)) return -1;
            snake.addFirst(new Point(x, y));
            return score;
        }

        class Point {
            int row, col;
            public Point(int r, int c) {
                this.row = r;
                this.col = c;
            }
        }
    }

    public static void main(String[] args) {
        SnakeGame s = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{2,2}});
        System.out.println(s.move("D"));
        System.out.println(s.move("D"));
        System.out.println(s.move("R"));
        System.out.println(s.move("U"));
        System.out.println(s.move("U"));
        System.out.println(s.move("L"));
        System.out.println(s.move("D"));
        System.out.println(s.move("R"));
        System.out.println(s.move("R"));
        System.out.println(s.move("U"));
        System.out.println(s.move("L"));
        System.out.println(s.move("D"));
    }
}
