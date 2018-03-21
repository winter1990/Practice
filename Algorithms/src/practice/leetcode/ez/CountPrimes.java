package practice.leetcode.ez;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */

public class CountPrimes {
    public int countPrimes1(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        // half of numbers are even
        int c = n / 2;

        boolean[] s = new boolean[n];
        /**
         * for each prime i, iterate through odd composites
         * i*i must be comp, i*i+i is comp, so i*i+a*i comp
         * i*i+i must be even
         *
         * for c=n/2, all even numbers are counted already
         * so i*i+a*i needless
         */
        for (int i = 3; i * i < n; i += 2) {
            if (s[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i * 2) {
                if (!s[j]) {
                    c--;
                    s[j] = true;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        boolean[] b = new boolean[2];
        System.out.println(b[0] + " " + b[1]);
    }
}
