package practice.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @array
 *
 * calculate the time for each car to arrive the target
 * for each car from the rightmost to left, keep track of the slowest -> the blocker and limit of the cars after
 * if the next car is faster, which means arrives target in less time, it will combine with previous car
 * otherwise, it will become the 'blocker'
 *
 * data structure:
 * mapping relation between time and cars and position should be sorted -> tree map
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(-position[i], (double) (target - position[i]) / speed[i]); // start from rightmost
        }
        int count = 0;
        double slowest = 0;
        for (double t : map.values()) { // returns the values in ascending order of the corresponding keys
            if (t > slowest) {
                slowest = t;
                count++;
            }
        }
        return count;
    }

    /**
     * wrong solution
     * if we re-order the cars, the resultmay be changed incorrectly because whne two cars meet, the speed changes
     * immediately
     *
     * first thought, find some way to sort
     * because the rightmost car is the 'blocker'
     * position & speed -> a list of cars with position and speed -> int[], [0] position and [1] speed
     * sort by position
     * start from the last one -> right most car
     * calculate the meeting point and compare with destination/target if > target, fleet++, otherwise combined
     */
    public int carFleet1(int target, int[] position, int[] speed) {
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(list, (a, b) -> (a[0] - b[0]));
        int count = position.length;
        for (int i = list.size() - 2; i >= 0; i--) {
            int[] left = list.get(i);
            int[] right = list.get(i + 1);
            if (left[1] > right[1] && left[0] + right[1] * (double)(right[0] - left[0]) / (double)(left[1] - right[1]) <= target) {
                left[1] = right[1];
                count--;
            }
        }
        return count;
    }
}
