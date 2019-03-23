package practice.leetcode.question;

/**
 * @string
 *
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W).
 * You also have several balls in your hand.
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost
 * place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls.
 * Keep doing this until no more balls can be removed.
 * Find the minimal balls you have to insert to remove all the balls on the table.
 * If you cannot remove all the balls, output -1.
 *
 * Input: "WRRBBW", "RB", Output: -1
 * Input: "WWRRBBWW", "WRBRW", Output: 2
 * Input:"G", "GGGGG", Output: 2
 * Input: "RBYYBBRRB", "YRBGB", Output: 3
 * "RRWWRRBBR", "WB" -> R[B]RWWRRBBR -> RBRWW[W]RRBBR -> empty
 * 
 */
public class ZumaGame {
    public int findMinStep(String board, String hand) {
        int[] c = new int[128];
        for(char x : hand.toCharArray()){
            c[x]++;
        }
        return  findMin(board, c);
    }

    private int findMin(String s, int[] c) {
        if (s.equals("")) return 0;
        int res = 2 * s.length() + 1;
        int i = 0;
        while (i < s.length()) {
            int j = i++;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) i++;
            int inc = 3 - (i - j);
            if (c[s.charAt(j)] >= inc) {            // we have enough balls in hands
                int used = inc <= 0 ? 0 : inc;      // might be 3 or more in a row, no need to use ball in hand
                c[s.charAt(j)] -= used;
                int temp = findMin(s.substring(0, j) + s.substring(i), c);
                if (temp >= 0) res = Math.min(res, used + temp);
                c[s.charAt(j)] += used;
            }
        }
        return res == 2 * s.length() + 1 ? -1 : res;
    }

    public static void main(String[] args) {
        String a = "RRWWRRBBR", b = "WB";
        ZumaGame zg = new ZumaGame();
        System.out.println(zg.findMinStep(a, b));
    }
}
