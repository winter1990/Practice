package practice.leetcode.ez;

public class NumArray {

    int[] arr;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        arr = new int[n];
        if (arr.length > 0) {
            arr[0] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return arr[j] - arr[i] + nums[i];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{};
        NumArray na = new NumArray(arr);
        System.out.println(na.sumRange(0,2));
    }
}
