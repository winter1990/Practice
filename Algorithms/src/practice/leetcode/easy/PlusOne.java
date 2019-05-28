package practice.leetcode.easy;

/**
 * @array
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in
 * the array contain a single digit.
 *
 * [1 2 3] - [1 2 4]   -- 1
 * [1 9 9] - [2 0 0]   -- 2
 * [9 9 9] - [1 0 0 0] -- 3
 *
 * if a[i] < 9, plus one and return
 * otherwise, a[i] = 0 until next digit < 9 -> case 1 and 2 can be combined
 * at last, return new int[n+1], res[0]=1
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int [n+1];
        res[0] = 1;
        return res;
    }
}
