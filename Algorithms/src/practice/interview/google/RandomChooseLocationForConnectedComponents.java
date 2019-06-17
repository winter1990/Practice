package practice.interview.google;

import java.util.Random;

public class RandomChooseLocationForConnectedComponents {
    public int[][] generateBoard(int m, int n) {
        int[][] board = new int[m][n];
        while (true) {
            generateRandomBoard(board, m, n, 1, 1);
            if (validBoard(board, m, n)) break;
        }
        return board;
    }

    private void generateRandomBoard(int[][] board, int m, int n, int val, int count) {
        if (count == m * n) return;
        Random random = new Random();
        int rand = random.nextInt(m * n);
        int row = rand / n;
        int col = rand % n;
        if (board[row][col] != 0) {
            generateRandomBoard(board, m, n, val, count);
        } else {
            generateRandomBoard(board, m, n, val == 4 ? 1 : val + 1, count + 1);
        }
    }

    private boolean validBoard(int[][] board, int m, int n) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        for (int i= 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) c1=countComponent(board, i, j, 1);
                if (board[i][j] == 2) c2=countComponent(board, i, j, 2);
                if (board[i][j] == 3) c3=countComponent(board, i, j, 3);
                if (board[i][j] == 4) c4=countComponent(board, i, j, 4);
            }
        }
        if (c1 + c2 + c3 + c4 != m * n) return false;
        return true;
    }

    private int countComponent(int[][] board, int i, int j, int target) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != target) {
            return 0;
        }
        board[i][j] = -target;
        return 1 + countComponent(board, i - 1, j, target) + countComponent(board, i + 1, j, target) + countComponent(board, i, j - 1, target) + countComponent(board, i, j + 1, target);
    }

    public static void main(String[] args) {
        RandomChooseLocationForConnectedComponents r = new RandomChooseLocationForConnectedComponents();
        int[][] res = r.generateBoard(4,4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
