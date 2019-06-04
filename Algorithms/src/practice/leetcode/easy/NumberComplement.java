package practice.leetcode.easy;

/**
 * @array
 * @bitwise
 *
 * 10011, 19
 * the complement is 01100 12
 * sum up is 11111
 *
 * so, get the min number that is larger than num
 *
 */
public class NumberComplement {
    public int findComplement(int num) {
        int sum = 0, i = 0;
        while (sum < num) sum += Math.pow(2, i++);
        return sum - num;
    }

    // TLE with the input Integer.MAX
    public int findComplement1(int num) {
        int sum = 1;
        while (sum <= num) sum <<= 1;
        return sum - 1 - num;
    }

    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(2147483647));
    }
}
