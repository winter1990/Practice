package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @greedy
 *
 * sort the points first based on start point
 * the arrow needs to cross the overlapped part as much as it can
 * keep track of the maxStart and minimumEnd
 * if maxStart <= minEnd, overlap slot
 * if          >        , need another shot, so count++
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // can also written as Java 8 lambda
        // Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int count = 1;
        int maxStart = points[0][0];
        int minEnd = points[0][1];
        for (int[] point : points) {
            int newStart = Math.max(maxStart, point[0]);
            int newEnd = Math.min(minEnd, point[1]);
            if (newStart <= newEnd) {
                maxStart = newStart;
                minEnd = newEnd;
            } else {
                count++;
                maxStart = point[0];
                minEnd = point[1];
            }
        }
        return count;
    }

    /**
     * above solution is a little bit redundant
     * think about sort by end
     * what is the condition that we need a new "thread"? it is the end of the first interval
     * so we can initialize the position of arrow at end point of first interval
     */
    public int findMinArrowShots1(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons mn = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] input = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(mn.findMinArrowShots(input));
    }
}
