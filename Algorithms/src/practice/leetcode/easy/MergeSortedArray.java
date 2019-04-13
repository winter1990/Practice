package practice.leetcode.easy;

/**
 * @array
 *
 * if compare from the first element, we need to shift all the elements after to the right and iterate the shift
 * so, start from the last element. two pointer for two arrays
 * while (i>=0 && j >=0)
 * check the leftover elements at last - if some elements in second array smaller
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i--];
            } else {
                nums1[index] = nums2[j--];
            }
            index--;
        }
        while (j >= 0) {
            nums1[index--] = nums2[j];
        }
    }
}
