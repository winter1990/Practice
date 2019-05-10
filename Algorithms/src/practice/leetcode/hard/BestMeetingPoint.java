package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @sort
 *
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * Input:
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * Output: 6
 *
 * start with 1D line [1 2 5 7] -> sorted the meeting point must be between [1 7]
 * no matter which point to choose, the distance = 7 - 1
 * then consider [2 5], the point between is the minimum distance, so distance += 5 - 3
 * expand to horizontal and vertical
 * consider separately of x-axis and y-axis
 *
 * put all x and y in different lists
 * sort and get distance for each pair
 *   odd/even elements in list
 *     if even, dis += a[r]-a[l]
 *     if odd, the last element in the middle point is the meeting point
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        return getMinDistance(row) + getMinDistance(col);
    }

    private int getMinDistance(List<Integer> list) {
        Collections.sort(list);
        int l = 0, r = list.size() - 1;
        int total = 0;
        while (l < r) {
            total += list.get(r) - list.get(l);
            l++;
            r--;
        }
        return total;
    }
}
