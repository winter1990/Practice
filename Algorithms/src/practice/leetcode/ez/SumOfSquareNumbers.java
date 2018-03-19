package practice.leetcode.ez;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int len = (int)Math.sqrt(c) + 1;
        int[] square = new int[len];
        for (int i = 1; i < len; i++) {
            square[i] = i * i;
        }
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = len - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int target = c - i * i;
                if (square[mid] == target) {
                    return true;
                } else if (square[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        System.out.println(s.judgeSquareSum(5));
    }
}
