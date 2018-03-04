package practice.leetcode.ez;

/**
 * reverse the number (necessary)
 * => reverse half of the number
 *
 * even/odd digit?
 * when stop?
 *
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
