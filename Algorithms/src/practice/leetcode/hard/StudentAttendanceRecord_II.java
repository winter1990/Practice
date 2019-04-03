package practice.leetcode.hard;

/**
 * @string
 * @dp
 *
 * Given a positive integer n, return the number of all possible attendance records with length n,
 * which will be regarded as rewardable.
 * Input: n = 2 Output: 8
 * Explanation: There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 *
 * intuition:
 * dp array to store number of combos
 * n = 1, (A) P L
 * n = 2, (PA AP LA AL) PP PL LP LL
 * whether we can add A/L/P depends on last letter in the string
 * so, use 3 dp array for A L and P
 * dp[i] represents number of combos with length i, end with A/L/P
 * P[n] = A[n-1] + P[n-1] + L[n-1]              1
 * L[n] = A[n-1] + A[n-2] + P[n-1] + P[n-2]     2
 * A[n] = LnoA[n-1] + PnoA[n-1]                 3
 * PnoA[n] = PnoA[n-1] + LnoA[n-1]              4
 * LnoA[n] = PnoA[n-1] + PnoA[n-2]              5
 * total[n] = A[n] + L[n] + P[n]
 * 3 4 5 -> A[n] = A[n-1] + A{n-2] + A[n-3]
 *
 * formula
 * A[n] = A[n-1] + A{n-2] + A[n-3]
 * L[n] = A[n-1] + A[n-2] + P[n-1] + P[n-2]
 * P[n] = A[n-1] + P[n-1] + L[n-1]
 * initialize p[1] l[1] l[2] a[1] a[2] a[3]
 */
public class StudentAttendanceRecord_II {
    public int checkRecord(int n) {
        if (n == 1) return 3;
        if (n == 2) return 8;
        int[] dp = new int[n + 1];
        int m = 1000000007;
        int[] a = new int[n + 1], l = new int[n + 1], p = new int[n + 1];
        p[1] = 1;
        l[1] = 1;
        l[2] = 3;
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        for (int i = 2; i <= n; i++) {
            a[i - 1] %= m;
            l[i - 1] %= m;
            p[i - 1] %= m;
            p[i] = ((a[i - 1] + p[i - 1]) % m + l[i - 1]) % m;
            if (i > 2) l[i] = ((a[i - 1] + a[i - 2]) % m + (p[i - 1] + p[i - 2]) % m) % m;
            if (i > 3) a[i] = ((a[i - 1] + a[i - 2]) % m + a[i - 3]) % m;
        }
        return ((a[n] + l[n]) % m + p[n]) % m;
    }

    static final int M = 1000000007;
    public int checkRecord1(int n) {
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }

        long res = PorL[n];
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }

        return (int) res;
    }


    public static void main(String[] args) {
        StudentAttendanceRecord_II s = new StudentAttendanceRecord_II();
        System.out.println(s.checkRecord(4));
        System.out.println(s.checkRecord1(4));
    }
}
