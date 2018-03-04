package practice.leetcode.medium;

/**
 * 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * 3 pointers - r w b
 * swap
 * 31212,0 0 4, 21213 12213 12213 11223
 * what if all 0/1/2
 *
 *
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int r = 0;
        int w = 0;
        int b = len - 1;
        while (w <= b) {
            if (nums[w] == 1) {
                w++;
            } else if (nums[w] == 0) {
                swap(nums, r, w);
                r++;
                w++;
            } else if (nums[w] == 2) {
                swap(nums, w, b);
                b--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }

    public static void main(String[] args) {
        SortColors sc =new SortColors();
        int[] in = {2,1,2,1,0};
        sc.sortColors(in);
        for (int i = 0; i < in.length; i++) {
            System.out.println(in[i]);
        }
    }
}
