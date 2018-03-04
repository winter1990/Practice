package practice.leetcode.ez;

/**
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
 *
 * 6 8 10 12 15 18 20...
 */

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num/= 3;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
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

    public static void main(String[] args) {
        int i = 1;
        UglyNumber un = new UglyNumber();
        System.out.println(un.isUgly(14));
    }
}
