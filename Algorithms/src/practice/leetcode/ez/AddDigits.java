package practice.leetcode.ez;

/**
 * @math
 *
 * 38 3+8=11 1+1=2
 */
public class AddDigits {
    public int addDigits(int num) {
        int res = 0;
        while (num / 10 != 0) {
            res = 0;
            while (num != 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
        }
        return num;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        int n = 38;
        System.out.println(ad.addDigits(n));
    }
}
