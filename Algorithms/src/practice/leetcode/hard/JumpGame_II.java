package practice.leetcode.hard;

public class JumpGame_II {
    public int jump(int[] nums) {
        int count = 0;
        int s = 0, e = 0;

        while (s <= e) {
            if (e >= nums.length - 1) {
                break;
            }
            int max = 0;
            for (int i = s; i <= e; i++) {
                max = Math.max(max, nums[i] + i);
            }
            count++;
            s = e + 1;
            e = max;
        }

        return count;
    }
}
