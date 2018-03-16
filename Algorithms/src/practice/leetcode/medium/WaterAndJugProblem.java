package practice.leetcode.medium;

/*
You need to determine whether it is possible to measure exactly z litres using these two jugs.
Input: x = 3, y = 5, z = 4
Output: True
Input: x = 2, y = 6, z = 5
Output: False
 */

/**
 * think about the case 3 5 and target=4
 * 3,5 are the numbers we can get directly
 * 3-(5-3)=1 is the number we can get
 * 3-(3-(5-3)=2 is the number we can get
 *
 *  Idea: property of Bézout’s identity and check if z can be divided by GCD(x, y)
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y || z == (x + y)) {
            return true;
        }
        if (z > x + y) {
            return false;
        }
        return z % GCD(x, y) == 0;
    }

    // Greatest Common Divisor
    private int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }
}
