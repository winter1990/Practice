package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * assume that the array is non-empty and the majority element always exist in the array.
 *
 * problems to solve:
 * 1. does even odd number matters? [1 1 1 2] [1 1 1 2 3], count > n/2
 *
 * method 1
 * use a hash map to store the number and freq, when we see some element count > n/2, return
 * O(n), O(n)
 *
 * method 2
 * sort the array and get the element in the middle
 * O(NlogN), O(1)
 *
 * method 3
 * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
 * Boyer-Moore algorithm
 * In the first pass, we generate a single candidate value which is the majority value if there is a majority.
 * The second pass simply counts the frequency of that value to confirm.
 * In the first pass, we need 2 values:
 *   A candidate value, initially set to any value.
 *   A count, initially set to 0.
 * For each element in our input list, we first examine the count value.
 * If the count is equal to 0, we set the candidate to the value at the current element.
 * Next, first compare the element's value to the current candidate value.
 * If they are the same, we increment count by 1. If they are different, we decrement count by 1.
 *
 * use one counter - count of major element is more than all other elements combined
 * [2 1 1 1 3 2 4 2 2 2 2]
 * [1 3 2 2 2 1 1 1 1]
 * count and track element
 * if count = 0, major = n
 * n = major count++
 * else count--
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        int count = 0, major = 0;
        for (int n : nums) {
            if (count == 0) major = n;
            if (n == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

}
