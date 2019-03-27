package practice.leetcode.ez;

/**
 * @array
 *
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts
 * with equal sums.
 *
 * sum up all numbers in array
 * in second pass, check current sum and if equal to target, reset to 0 and count++. otherwise continue
 * [0 0 0 0 0]
 *
 * [2 -1 1 2 2]
 * [-2 3 5]
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        if (sum % 3 != 0) return false;
        int target = sum / 3, count = 0, cur = 0;
        for (int a : A) {
            cur += a;
            if (cur == target) {
                cur = 0;
                count++;
            }
        }
        return count >= 3;
    }

    public static void main(String[] args) {
        PartitionArrayIntoThreePartsWithEqualSum p = new PartitionArrayIntoThreePartsWithEqualSum();
        int[] in = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(p.canThreePartsEqualSum(in));
    }
}
