package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * method 1:
 * use map to keep track of the frequency
 *
 * algorithm should run in linear time and in O(1) space
 *
 * method 2:
 * sort the numbers,the numbers at 1/3 2/3 must be the numbers - O(logn)
 *
 * method 3:
 * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
 *
 */
public class MajorityElement_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) {
                c1++;
            } else if (nums[i] == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) {
                c1++;
            } else if (nums[i] == n2) {
                c2++;
            }
        }
        if (c1 > nums.length / 3) {
            res.add(n1);
        }
        if (c2 > nums.length / 3) {
            res.add(n2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,1,1,4,3,2,3,3,2};
        MajorityElement_II me = new MajorityElement_II();
        System.out.println(me.majorityElement(in));
    }
}
