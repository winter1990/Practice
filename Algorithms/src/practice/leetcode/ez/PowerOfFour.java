package practice.leetcode.ez;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Math.pow(4, 15));   // 1073741824
    }
}
