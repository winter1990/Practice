package practice.leetcode.hard;

/**
 * @array
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * nums = [7,2,5,10,8], m = 2
 * Output: 18, [7 2 5] and [10 8]
 *
 * [15 3 2 20 6 12 5 12] 4 -> 15 3 2 | 20 | 6 12 | 5 12
 * sum = 75, 75 / 4 = 18.75 so the smallest is 19
 * we cannot calculate like this because we cannot guarantee that the subarray can be grouped and sum is close to sum/m
 * for example [20 19 18 1 2 4], m = 3
 *
 * target - minimize the largest sum
 * [1 3 4 50], m = 3
 * the range of result value should be between max value in the array and the sum of the array
 * we have left bound and right bound left = max, right = sum
 * narrow down the left and right
 *   if we can divide the array into more than m, left = mid + 1
 *   if we cannot divide the array into m, value too large, right = mid - 1
 * need to define a method to check how many can be divided
 */
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int lo = 0;
        int hi = 0;
        for (int i : nums) {
            lo = Math.max(lo, i);
            hi += i;
        }
        if (m == 1) return hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValidSplit(nums, mid, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean isValidSplit(int[] arr, int target, int m) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > target) {
                count++;
                sum = arr[i];
            }
            if (count > m) return false;
        }
        return true;
    }

    /**
     * follow up - maximize the smallest piece
     * 5 1 2 6, m = 3 -> 5 | 1 2 | 6
     * lo = 1, hi = 14
     * mid = 7
     * 5 1 | 2 | 6
     * valid - [1 6]
     * mid = 3
     */
    public static int maxSmallestSpli(int[] arr, int m) {
        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for (int a : arr) {
            hi += a;
            lo = Math.min(a, lo);
        }
        if (m == 1) return hi;
        if (m == arr.length) return lo;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValid(arr, mid, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean isValid(int[] arr, int target, int m) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > target) {
                count++;
                sum = 0;
            }
            if (count > m) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,2,2,12,6};
        int m = 3;
        System.out.println(maxSmallestSpli(arr,3));
//        System.out.println(splitArray(arr,3));
//        SplitArrayLargestSum sa = new SplitArrayLargestSum();
//        int[] in = {7,2,5,10,8};
//        sa.splitArray(in, 2);
    }
}
