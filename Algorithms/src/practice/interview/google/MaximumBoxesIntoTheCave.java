package practice.interview.google;

import java.util.Arrays;


/**
 * heights = [4 5 3 8 7 6]
 *           [3 3 3 6 6 6]
 * boxes = [8 4 1 3 5 6 9 12]
 *         [1 3 4 5 7 8 9 12]
 */
public class MaximumBoxesIntoTheCave {
    public int maximumObjects(int[] heights, int[] boxes) {
        int m = heights.length, n = boxes.length;
        int[] minHeight = new int[m];
        minHeight[m - 1] = heights[m - 1];
        for (int i = m - 2; i >= 0; i--) minHeight[i] = Math.min(minHeight[i + 1], heights[i]);
        Arrays.sort(boxes);
        int count = 0, index = 0;
        for (int i = 0; i < m; i++) {
            if (boxes[index] <= minHeight[i]) {
                index++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumBoxesIntoTheCave m = new MaximumBoxesIntoTheCave();
        int[] h = {4,5,3,8,7,6};
        int[] b = {8,4,1,3,5,7,9,12};
        System.out.println(m.maximumObjects(h,b));
    }
}
