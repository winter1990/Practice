package practice.leetcode.ez;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits app = new NumberOf1Bits();
        System.out.println(app.hammingWeight(5));
    }
}