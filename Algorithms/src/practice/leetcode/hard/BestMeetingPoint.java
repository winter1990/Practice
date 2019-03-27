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
 * start with 1D line [1 2 5 7] -> sorted the meeting point must be between [1 7]
 * no matter which point to choose, the distance = 7 - 1
 * then consider [2 5], the point between is the minimum distance, so distance += 5 - 3
 * expand to horizontal and vertical
 * consider separately of x-axis and y-axis
 *
 * put all x and y in different lists, sort and get distance for each pair
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> list1 = new ArrayList<>(); // row
        List<Integer> list2 = new ArrayList<>(); // col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        return getMinDistance(list1) + getMinDistance(list2);
    }

    private int getMinDistance(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        int total = 0;
        Collections.sort(list);
        while (l < r) {
            total += list.get(r--) - list.get(l++);
        }
        return total;
    }
}
