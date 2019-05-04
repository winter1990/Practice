package practice.leetcode.medium;

/**
 * @math
 *
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * problems to solve:
 * 1. it's obvious that n/2 is faster than n-1
 * 2. how +1 and -1 makes difference
 * 3. shortest
 *
 * 7 0111 - 1000 - 100 - 10 - 1
 *   0111 - 0110 - 011 - 10 - 1
 *   the same count
 *
 * for each move if we just think about "removing as many 1s as possible"
 * 111011 - 111010 - 11101 - 11100 - 1110 - 111 - 1000 - 100 - 10 - 1
 *        - 111100 - 11110 - 1111 - 10000 - 1000 - 100 - 10  - 1
 *
 * while both +/-1 is creating another 0 for the next round to operate n/2
 * n+1 potentially move the 1 to the left so that we are doing better in next round to create tailing 0s for the next rounds
 * there is only one exception: 3 which requires two steps to reach 1
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else {
                if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                    n--;
                } else {
                    n++;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        IntegerReplacement i = new IntegerReplacement();
        System.out.println(i.integerReplacement(2147483647));
    }
}
