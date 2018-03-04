package practice.interview;

import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();

        while (true) {
            String word = in.nextLine();
            if (!word.equals("")) words.add(word);
            if (word.isEmpty()) break;
        }

        List<String> target = new ArrayList<>();

        while (in.hasNextLine()) {
            String word = in.nextLine();
            if (!word.equals("")) target.add(word);
            if (word.isEmpty()) break;
        }

        char[][] cs = new char[words.size()][words.get(0).length()];
        int m = words.size();
        int n = words.get(0).length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cs[i][j] = words.get(i).charAt(j);
            }
        }

        Map<String, int[]> res = new HashMap<>();
        boolean[][] checker = new boolean[m][n];
        for (String word : target) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word.charAt(0) == cs[i][j] && findWord(cs, word, 0, i, j, checker)) {
                        int[] index = new int[2];
                        index[0] = i;
                        index[1] = j;
                        if (!res.containsKey(word)) res.put(word, index);
                        for (int k = 0; k < m; k++) {
                            Arrays.fill(checker[k], false);
                        }
                        break;
                    }
                }
            }
        }
        printResult(res, target);

    }

    private static void printResult(Map<String, int[]> res, List<String> target) {
        for (String s : target) {
            if (res.containsKey(s)) {
                System.out.println(s + " " + res.get(s)[0] + " " + res.get(s)[1]);
            } else {
                System.out.println(s + " " + -1 + " " + -1);
            }
        }
    }

    private static boolean findWord(char[][] board, String word, int index, int i, int j, boolean[][] checker) {
        if (index == word.length()) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        } else if (checker[i][j]) {
            return false;
        } else if (word.charAt(index) != board[i][j]) {
            return false;
        }
        checker[i][j] = true;
        if (
                   findWord(board, word, index + 1, i - 1, j, checker)
                || findWord(board, word, index + 1, i + 1, j, checker)
                || findWord(board, word, index + 1, i, j - 1, checker)
                || findWord(board, word, index + 1, i, j + 1, checker)
                || findWord(board, word, index + 1, i - 1, j + 1, checker)
                || findWord(board, word, index + 1, i - 1, j - 1, checker)
                || findWord(board, word, index + 1, i + 1, j + 1, checker)
                || findWord(board, word, index + 1, i + 1, j - 1, checker)) {
            return true;
        }
        checker[i][j] = false;
        return false;
    }
}

/*
ABCD
PRAT
KITA
ANDY

ANDY
CAT
DOG

 */