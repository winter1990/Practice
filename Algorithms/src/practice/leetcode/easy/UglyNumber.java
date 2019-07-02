package practice.leetcode.easy;

/**
 * @math
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
 *
 * keep removing the factor 2/3/5 in the number
 * while (n % 2/3/5 != 0) n/= 2/3/5
 * use 3 while loops to divide the factors
 * check if the result = 1 at the end
 */

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public boolean isUgly1(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
