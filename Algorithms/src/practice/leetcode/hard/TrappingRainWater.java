package practice.leetcode.hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int n = height.length;
        int[] ltr = new int[n];
        int[] rtl = new int[n];
        int max = height[0];
        for (int i = 1; i < n; i++) {
            max = height[i] > max ? height[i] : max;
            ltr[i] = max;
        }
        max = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            max = height[i] > max ? height[i] : max;
            rtl[i] = max;
        }
        int vol = 0;
        for (int i = 1; i < n - 1; i++) {
            vol += Math.min(ltr[i], rtl[i]) - height[i];
        }
        return vol;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] in = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(t.trap(in));
    }
}
