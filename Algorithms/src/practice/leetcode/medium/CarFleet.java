package practice.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @array
 *
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the
 * target along the road.
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 *
 * based on the description, whether two cars can be combined depends on the slowest car on the rightmost
 * sorting the car based on arrival time not applicable as when blocked, it will change the speed to slower one on right
 * start from right car
 * we need to position to be sorted -> sort or tree map -> key is in ascending order by default
 * key: -position[i] can make sure when scanning the map, we start with right car
 * value: how much time needed to arrive target
 * keep track of the slowest speed
 * if current cars's time > slowest, count++ and update slowest value
 *
 * The collection's iterator returns the values in ascending order of the corresponding keys.
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) map.put(-position[i], (double)(target - position[i]) / speed[i]);
        double slowest = 0;
        int count = 0;
        for (double time : map.values()) {
            if (time > slowest) {
                slowest = time;
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
