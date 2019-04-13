package practice.leetcode.easy;

/**
 * @math
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * Input: 10, Output: 4, Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * brute force:
 * from 2 to n - 1, if n % i != 0, then count++
 *
 * use boolean array with size n to track whether it is prime or not
 * start with first prime - 2
 * for all the integers start from 2, times that prime number, will be non-prime
 * for i = [2,n]
 * if i is prime, count++
 *   for j = [2, i * j < n]
 * time complexity O(N log (log N))
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

    /**
     * most straightforward method
     */
    public int countPrimes3(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] b = new boolean[2];
        System.out.println(b[0] + " " + b[1]);
    }
}
