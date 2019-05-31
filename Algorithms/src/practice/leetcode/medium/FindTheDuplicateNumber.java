package practice.leetcode.medium;

/**
 * @array
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at
 * least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * method 1
 * with extra space
 * walk through the array and add each number in to a set, check if exists
 * O(N), O(N)
 *
 * method 2
 * brute force
 * two loops to find duplicates
 * O(N^2), O(1)
 *
 * method 3
 * think about using the property of element is [1,n] and total number of elements is (n+1) -> index [0,n]
 *  0 1 2 3 4 5
 * [2 1 3 5 2 4]
 *  2 3         initial value of a = a[0], b = a[a[0]]
 *  3 4
 *  5 3
 *  4 4
 *  -------
 *  4 0
 *  2 2 -> duplicate
 *
 * use the value in the array as index, if there are duplicates, it means two values are pointing to the same index
 * if we traverse the array based on value as index, then there must be a loop exists
 * for index->value pair of the array, there are two cases:
 *   value = index, unless there is another value pointing to this index, otherwise it will not be visited
 *   value != index, then use the value as index for next step
 *
 * the list start with index 0 is:
 *    [2   1   3   5   2   4]
 * idx 0 - 2 - 3 - 5 - 4 - 2 (loop exists)
 * val 2 - 3 - 5 - 4 - 2
 * slow and fast:
 * as the stop condition is slow == fast, so to start, we cannot initialize slow = 0 and fast = a[0]
 * because they should start at the same point
 * by assigning slow = a[0], fast = a[a[0]], we the presuming one loop is done initially
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        int[] in = {2,1,3,5,4,4};
        System.out.println(f.findDuplicate1(in));
    }
}
