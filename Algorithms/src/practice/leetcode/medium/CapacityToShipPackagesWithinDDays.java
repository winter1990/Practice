package practice.leetcode.medium;

/**
 * @array
 * @binarysearch
 *
 * translation:
 * partition the array into D chunks
 * return the minimum sum of the subarray
 *
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length, start = weights[n - 1], end = 0;
        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(weights, D, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isValid(int[] weights, int d, int target) {
        int sum = 0, count = 1;
        for (int w : weights) {
            sum += w;
            if (sum > target) {
                sum = w;
                ++count;
                if (count > d) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
//        int[] in = {1,2,3,4,5,6,7,8,9,10}; int d = 5;
        int[] in = {1,2,3,1,1}; int d = 4;
        System.out.println(c.shipWithinDays(in, d));
    }
}
