package practice.leetcode.easy;

/**
 * @array
 */
public class TwoSum_II_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[]{};
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] > target) {
                hi--;
            } else if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                return new int[]{lo + 1, hi + 1};
            }
        }
        return new int[]{};
    }

    // O(nlogn) time, O(1) space
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int s = i + 1;
            int e = numbers.length - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                int val = target - numbers[i];
                if (numbers[mid] == val) {
                    int[] res = new int[2];
                    res[0] = i + 1;
                    res[1] = mid + 1;
                } else if (numbers[mid] > val) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return new int[2];
    }
}
