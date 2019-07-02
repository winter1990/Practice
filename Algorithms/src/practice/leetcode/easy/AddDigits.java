package practice.leetcode.easy;

/**
 * @math
 *
 * 685 -> 6+8+5=19 -> 1+9=10 -> 1+0=1 end
 * the condition is while number is >= 10, we keep calculating
 * while (n >= 10)
 * while n!=0, m += n%10, n/=10, after n=m
 */
public class AddDigits {
    public int addDigits(int num) {
        int val = 0;
        while (num / 10 != 0) {
            while (num != 0) {
                val += num % 10;
                num /= 10;
            }
            num = val;
            val = 0;
        }
        return num;
    }
}
