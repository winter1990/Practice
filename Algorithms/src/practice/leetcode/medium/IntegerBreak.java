package practice.leetcode.medium;

/**
 * start with two integers: f(x)=x * (n-x)
 * the maximum of product is n/2 * n/2 if n is even and (n-1)/2 * (n+1)/2
 * when f(x)>n, do the break
 * n/2 * n/2 >=n n=4
 * (n-1)/2 * (n+1)/2 >=n n=5
 *
 * the result should not contain more than two '2'
 * for all integers n > 4, ((n-3)*3)>n
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
