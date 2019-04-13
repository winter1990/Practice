package practice.leetcode.easy;

/**
 * 10011, 19
 * the complement is 01100 12
 * sum up is 11111
 *
 * so, get the min number that is larger than num
 *
 */
public class NumberComplement {
    public int findComplement(int num) {
        int i = 0;
        int j = 0;
        while (i < num) {
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }

    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(19));
    }
}
