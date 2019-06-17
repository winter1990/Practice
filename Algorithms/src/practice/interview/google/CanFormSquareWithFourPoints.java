package practice.interview.google;

/**
 * 1 four sides are same
 * 2 diagonals middle points same
 * 3 slope of twp diagonals * = -1
 * sort?
 */
public class CanFormSquareWithFourPoints {
    public boolean canFormSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] lens = {getLen(p1, p2), getLen(p1, p3), getLen(p1, p4), getLen(p2, p3), getLen(p2, p4), getLen(p3, p4)};
        int side = Integer.MAX_VALUE, diagonal = 0;
        for (int i : lens) {
            diagonal = Math.max(diagonal, i);
            side = Math.min(side, i);
        }
        int sides = 0;
        int diagonals = 0;
        for (int len : lens) {
            if (len == side) sides++;
            if (len == diagonal) diagonals++;
        }
        return sides == 4 && diagonals == 2;
    }

    private int getLen(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public static void main(String[] args) {
        CanFormSquareWithFourPoints c = new CanFormSquareWithFourPoints();
        c.canFormSquare(new int[]{0,0},new int[]{1,0},new int[]{1,1},new int[]{0,1});
    }
}
