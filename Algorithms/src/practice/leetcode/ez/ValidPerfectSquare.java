package practice.leetcode.ez;

/**
 * binary search
 *
 * a b c, mid b
 * a b, mid a
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1 || num == 4) {
            return true;
        }
        long s = 1;
        long e = num / 2;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare valid = new ValidPerfectSquare();
        System.out.println(valid.isPerfectSquare(808201));
        System.out.println(valid.isPerfectSquare(104976));
    }
}
