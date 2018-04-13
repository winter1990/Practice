package practice.leetcode.ez;

/**
 * @array
 * @slidingwindow
 * @max
 */
public class MaximumAverageSubarray_I {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        int i = k;
        while (i < nums.length) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
            i++;
        }
        return max / k;
    }

    public static void main(String[] args) {
        int[] in = {1,12,-5,-6,50,3};
        MaximumAverageSubarray_I m = new MaximumAverageSubarray_I();
        System.out.println(m.findMaxAverage(in, 4));

    }
}
