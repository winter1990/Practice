package practice.leetcode.hard;

/**
 * @array
 * @dp
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it is able to trap after raining.
 *
 * at each bar in the graph, the water can be trapped depends on min(max left, max right)
 * water can be trapped = min(lmax, rmax) - a[i]
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, res = 0, lmax = 0, rmax = 0;
        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax) {
                res += (lmax - height[l]);
                l++;
            } else {
                res += (rmax - height[r]);
                r--;
            }
        }
        return res;
    }

    public int trap2(int[] height) {
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
//        System.out.println(t.trap(in));
    }
}
