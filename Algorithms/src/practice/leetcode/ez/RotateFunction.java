package practice.leetcode.ez;

/**
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise
 * F(k)  = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
 * F(k-1)= 0 * Bk-1[0]+1 * Bk-1[1]+... + (n-1) * Bk0[n-1]
 * Bk[n]=Bk[n-1]
 * F(k)-F(k-1) = Bk[1]+Bk[2]+Bk[n-1]-(n-1)*Bk0[n-1]
 *             = Bk[0]+Bk[1]+...Bk[n-1]-n*Bk0
 *             = total-nBk0, n is constant
 * F(k) = F(k-1) + total - nBk0
 * k=0 bk0 a[0]
 * k=1 bk0 a[len-1]
 * k=2 bk0 a[len-2]
 * ....
 *
 * f(k) = 0*bk[0] + 1*bk[1] + ... + (n-1)*bk[n-1]
 * f(0) = 0*a[0] + 1*a[1] + ...
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int total = 0;
        int len = A.length;
        int f = 0;
        for (int i = 0; i < len; i++) {
            total += A[i];
            f += i * A[i];
        }
        int max = f;
        for (int i = len - 1; i > 0; i--) {
            f = f + total - len * A[i];
            if (f > max) max = f;
        }
        return max;
    }
}
