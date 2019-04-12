package practice.leetcode.medium;

/**
 * @array
 *
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 *   Every element in left is less than or equal to every element in right.
 *   left and right are non-empty.
 *   left has the smallest possible size.
 * Return the length of left after such a partitioning
 *
 * Input: [5,0,3,8,6], Output: 3, Explanation: left = [5,0,3], right = [8,6]
 *
 * l to r: 5 5 5 8 8
 * r to l: 0 0 3 6 6
 */
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int n = A.length, ltr[] = new int[n], rtl[] = new int[n], max = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            ltr[i] = max;
            min = Math.min(min, A[n - 1 - i]);
            rtl[n - 1 - i] = min;
        }
        for (int i = 0; i < n - 1; i++) {
            if (ltr[i] <= rtl[i + 1]) return i + 1;
        }
        return -1;
    }

    /**
     * optimization:
     * keep track of cur/left max
     * keep track of the position of partition
     * scan through the array:
     *   if max value is larger then cur max, that is good
     *   if after that max value, there is an element smaller then cur max, then we should update the cur max as max
     *   and that is the reason, we also need to keep track of `max` which means the maximum value of all previous element
     */
    public int partitionDisjoint1(int[] A) {
        int curMax = A[0], pos = 0, max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < curMax) {
                pos = i;
                curMax = max;
            } else if (A[i] > max) {
                max = A[i];
            }
        }
        return pos + 1;
    }
    public static void main(String[] args) {
        PartitionArrayIntoDisjointIntervals p = new PartitionArrayIntoDisjointIntervals();
        int[] in = {5,0,3,8,6};
        System.out.println(p.partitionDisjoint(in));
        System.out.println(p.partitionDisjoint1(in));
    }
}
