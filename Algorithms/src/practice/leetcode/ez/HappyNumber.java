package practice.leetcode.ez;

import java.util.HashSet;
import java.util.Set;

/**
 * 19, 1+81=82, 64+4=68, 36+64=100
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (n != 0) {
            if (n == 1){
                return true;
            }
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            sum = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber hm = new HappyNumber();
        System.out.println(hm.isHappy(3));
    }
}
