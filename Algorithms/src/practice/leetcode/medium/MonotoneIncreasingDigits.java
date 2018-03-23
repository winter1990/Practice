package practice.leetcode.medium;

/**
 * find the largest number that is less than or equal to N with monotone increasing digits
 * 137649 => 136999
 *
 * to char array first
 * start from last digit, to first one
 * if increasing
 *
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] cs = String.valueOf(N).toCharArray();
        int index = cs.length - 1;
        for (int i = index; i > 0; i--) {
            if (cs[i] - '0' < cs[i - 1] - '0') {
                index = i - 1;
                cs[index] -= 1;
            }
        }
        for (int i = index + 1; i < cs.length; i++) {
            cs[i] = '9';
        }
        return Integer.valueOf(new String(cs));
    }

    public static void main(String[] args) {
        int n = 100;
        MonotoneIncreasingDigits m = new MonotoneIncreasingDigits();
        System.out.println(m.monotoneIncreasingDigits(n));
    }
}
