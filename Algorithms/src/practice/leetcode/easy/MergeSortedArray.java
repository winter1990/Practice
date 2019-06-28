package practice.leetcode.easy;

/**
 * @array
 * @sort
 *
 * if compare from the first element, we need to shift all the elements after to the right and iterate the shift
 * so, start from the last element. two pointer for two arrays
 * while (i>=0 && j >=0)
 * check the leftover elements at last - if some elements in second array smaller
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, i = m + n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[i] = nums1[i1--];
            } else {
                nums1[i] = nums2[i2--];
            }
            i--;
        }
        while (i2 >= 0) nums1[i--] = nums2[i2--];
    }
}
