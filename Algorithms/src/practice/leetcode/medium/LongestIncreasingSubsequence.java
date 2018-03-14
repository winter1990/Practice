package practice.leetcode.medium;

/**
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 *
 * [10, 9, 2, 5, 3, 7, 18] -> 2 3 7 18. len=4
 * Could you improve it to O(n log n) time complexity?
 *
 * keep track of smallest tail of all increasing sub-sequences
 * len=1 2 (3 5 7 are also longest subsequence but tails are larger)
 * len=2 3 (2,5 2,7...)
 * len=3 7
 * len=4 18
 * len=5 NA
 * tails must be increasing array. Binary Search tail arr to see which value/sub-sequence needs to be updated
 * scan through the arr:
 * - if num[i] is smallest of all tails,start a new list with length 1
 * - if num[i] is larger than any tails, longer sub-seq found, extended
 * - if tails[i-1] < num[i] < tails[i],need to find largest tail that is smaller than num[i]
 * (1) if x is larger than all tails, append it, increase the size by 1
 * (2) if tails[i-1] < x <= tails[i], update tails[i]
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                ++size;
            }
        }
        return size;
    }

    // not correct
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] tails =  new int[len];
        tails[0] = nums[0];
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] > tails[maxLen - 1]) {
                tails[maxLen++] = nums[i];
            } else {
                int s = 0;
                int e = maxLen - 1;
                while (s < e) {
                    int mid = (s + e) / 2;
                    if (tails[mid] < nums[i]) {
                        s = mid + 1;
                    } else {
                        e = mid;
                    }
                }
                tails[s] = nums[i];
                if (s == maxLen) maxLen++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] ar = {10, 9, 2, 5, 3, 7, 18};
                //{3,5,6,2,5,4,19,5,6,7,12};
        LongestIncreasingSubsequence li = new LongestIncreasingSubsequence();
//        System.out.println(li.lengthOfLIS(ar));
        System.out.println(li.lengthOfLIS1(ar));
    }
}
