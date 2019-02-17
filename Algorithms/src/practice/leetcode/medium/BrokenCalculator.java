package practice.leetcode.medium;

/**
 * @math
 *
 * if x > y, then nothing we can do but subtraction, x - y
 * if x < y, y odd? (y+1)/2 is more efficient, y even y/2, keep divide by 2 until smaller than
 */
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        if (X > Y) {
            return X - Y;
        } else if (X == Y) {
            return 0;
        }
        int count = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            count++;
        }
        return X - Y + count;
    }

    public static void main(String[] args) {
        BrokenCalculator bc = new BrokenCalculator();
        System.out.println(bc.brokenCalc(1, 1000000000));
    }
}
