package practice.leetcode.ez;

/**
 * @math
 *
 * reverse the number (unnecessary, and may also have overflow issue)
 * => reverse half of the number
 *
 * even/odd digit?
 * 12321 => 12 123
 * 123321 => 123 123
 *
 * when stop? while (x > num)
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else if (x % 10 == 0) { // easy to miss the case
            return false;
        }

        int num = 0;
        while (num < x) {
            num *= 10;
            num += x % 10;
            x /= 10;
        }
        return (num / 10 == x) || (num == x);
    }
}
