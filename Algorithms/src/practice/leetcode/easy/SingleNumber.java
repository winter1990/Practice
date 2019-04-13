package practice.leetcode.easy;

/**
 * @bitwise
 *
 * method 1
 * bit operation
 * based on the principle: a ^ a = 0
 * O(N) O(1)
 *
 * method 2
 * hashmap Integer->Integer number->frequency
 * O(N) O(N)
 *
 * method 3
 * sort + binary search
 * one number odd, total number of elements is odd
 * 0 1 2 3 4 5 6 7 8
 * 1 1 2 4 4 5 5 8 8
 * get mid compare with previous element, if same, on the left
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

}
