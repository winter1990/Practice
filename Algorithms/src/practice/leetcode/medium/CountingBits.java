package practice.leetcode.medium;

/**
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 *        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * num=5,[0,1,1,2,1,2]
 * num=16[0,1,1,2,1,2,2,3,1,2  2  3  2  3  3  4  1]
 *
 * dp problem:
 * 2 4 8 16,2^x is the bound
 * fact 2
 */
public class CountingBits {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        int fact = 2;
        int index = 2;
        while (index <= num) {
            if (index == fact) {
                res[index] = 1;
                fact *= 2;
            } else {
                res[index] = 1 + res[index - fact / 2];
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        System.out.println(cb.countBits(1));
    }
}
