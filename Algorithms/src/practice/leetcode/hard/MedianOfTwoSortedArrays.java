package practice.leetcode.hard;

/**
 * @array
 * @search
 * @daq
 *
 * by definition, median number is used for dividing a set into two equal length subsets, and one subset is always
 * greater than the other one
 * for the two arrays:
 * left A             | right A
 * a[0] a[1]...a[i-1] | a[i] a[i+1]...a[m-1]
 * left B             | right B
 * b[0] b[1]...b[i-1] | b[i] b[i+1]...n[n-1]
 * our target is to find i and j, so that:
 * 1)len(leftA+B) = len(rightA+B)
 * 2)max left <= min right
 * divide [A B] into two parts, and left part is always less that right part
 * median = (max(left) + min(right) / 2 -> target
 *
 * so we need to make sure:
 * 1) i + j = m + n - i - j (+1)
 * 2) a[i] > b[j-1], b[j] > a[i-1]
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Integer.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Integer.min(len1, k / 2) - 1;
        int j = start2 + Integer.min(len2, k / 2) - 1;
        //Eliminate half of the elements from one of the smaller arrays
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    /**
     * https://www.youtube.com/watch?time_continue=178&v=LPFhl65R7ww
     * array 1: x1 x2 x3 x4 x5 x6
     * array 2: y1 y2 y3 y4 y5 y6 y7 y8
     * if we partition array 1:
     * x1 x2 | x3 x4 x5 x6
     * if we want to find the median, where we need to partition the array 2?
     * need to make sure the total elements on left of Aand B, equals to total elements on right
     * so we need to partition the array 2:
     * y1 y2 y3 y4 y5 | y6 y7 y8
     * now we partition the two arrays into left and right, how we can make sure it's median?
     * the pre-conditions are:
     * 1) x2 <= y6
     * 2) y5 <= x3
     * for this case, we can conclude that the median is:
     * even elements - (max(x2, y5) + min(x3, y6)) / 2
     * odd elements - max(x2, y5)
     * next we just need to find the partition index of two arrays
     *
     * binary search:
     * partitionX+partitionY = (x+y+1)/2
     * if
     *  max left X <= min right Y
     *  max left Y <= min right X
     *  then we found the target to partition the two arrays
     * else if
     *  max left X > min right Y
     *  move toward left in X
     * else
     *  move toward right in X
     *
     * a real example
     * x - 1  3  8  9 15        m = 5
     * y - 7 11 18 19 21 25     n = 6
     * start = 0, end = 4
     * partition x = 2, so for x, left size 2 and right size 3
     * partition y = (5+6+1)/2 - 2 = 4
     * x - 1  3       | 8  9 15
     * y - 7 11 18 19 | 21 25
     * check and compare 3 and 21
     * we are too far on left side
     * move on right side
     * so start = 3, end = 4
     * partition x = 3
     * partition y = 3
     * x - 1  3 8  | 9 15
     * y - 7 11 18 | 19 21 25
     * check 8 < 19 ? true, 18 < 9 ? false
     * it means we need to move further to right
     * start = 4, end = 4
     * partition x = 4, partition y = 2
     * x - 1  3 8 9 | 15
     * y - 7 11     | 18 19 21 25
     * 9 < 18 ? true, 8 < 18? true
     * all elements on left smaller than all on right side
     * max(9,11) bingo
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        int x = A.length;
        int y = B.length;
        int low = 0, high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;   // middle element in A
            int partitionY = (x + y + 1) / 2 - partitionX;        // in order to partition the two arrays into left and righ with same size

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : A[partitionX - 1]; // max in left A
            int minRightX = partitionX == x ? Integer.MAX_VALUE : A[partitionX];    // min in right A
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : B[partitionY - 1]; // max in left B
            int minRightY = partitionY == y ? Integer.MAX_VALUE : B[partitionY];    // min in right B

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return -1; //throw new IllegalArgumentException();

    }

}
