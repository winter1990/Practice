package practice.leetcode.easy;

/**
 * @greedy
 *
 * At a lemonade stand, each lemonade costs $5
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
 * you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change
 *
 * count number of 10 and 5
 * if bill is 20, give 10 first and then 5
 * if bill is 10, we can only give 5 for exchange and update count
 * if bill is 5, update count
 * if no more 5, and bill is not 5, then false
 * no need to count 20
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                count5--;
                count10++;
            } else {
                if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
            }
            if (count5 < 0) {
                return false;
            }
        }
        return true;
    }
}
