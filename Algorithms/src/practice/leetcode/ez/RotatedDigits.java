package practice.leetcode.ez;

/**
 * (0) (1) 2 5 6 9 | 12 15 16 19 | 20 21 22 25 26 29...
 *
 * must contain at LEAST a 2 5 6 9 and 1 0 8
 * must not contain 3 4 7
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        if (N <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (helper(i)) count++;
        }
        return count;
    }

    private boolean helper(int n) {
        boolean flag = false;
        while (n != 0) {
            int val = n % 10;
            if (val == 3) {
                return false;
            } else if (val == 4) {
                return false;
            } else if (val == 7) {
                return false;
            } else if (val == 2) {
                flag = true;
            } else if (val == 5) {
                flag = true;
            } else if (val == 6) {
                flag = true;
            } else if (val == 9) {
                flag = true;
            }
            n /= 10;
        }
        return flag;
    }

    public static void main(String[] args) {
        RotatedDigits rd = new RotatedDigits();
        System.out.println(rd.rotatedDigits(10));
    }
}
