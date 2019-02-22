package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @sort
 * @math
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * [9,12] 912 > 129
 * find a mechanism to sort the numbers based on first digit
 * concatenate as a string and compare using the method compare to
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // sort the array in descending order
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String st1 = s1 + s2;
                String st2 = s2 + s1;
                return st2.compareTo(st1);
            }
        });

        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
