package practice.leetcode.ez;

/**
 * @array
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1
 *
 * 0 1 1 2 3 5 8 13 21 34...
 */
public class FibonacciNumber {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        return fib1(N - 1) + fib1(N - 2);
    }
}
