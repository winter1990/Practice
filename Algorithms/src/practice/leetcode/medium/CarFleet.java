package practice.leetcode.medium;

import java.util.TreeMap;

/**
 * @array
 *
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the
 * target along the road.
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 *
 * start with two cars
 * ---------------------------d--->
 *       p1->s1      p2->s2
 * for car 2 - time to dest - t1 =(d-p2)/s2,
 * for car 2 - t2 = (d-p1)/s1
 * if t1 >= t2, one fleet. when they meet each other, s = min(s1,s2) - s 2
 * if a new car comes in and slower than previous two, then it becomes the new bottle neck for the cars behind
 * track the slowest car so far
 * start with rightmost car, get max time to reach dest
 * if smaller time, combined
 * if larger time, update new time to dest and count++
 * tree map
 *   key is position - we want to start from the rightmost car - so -position[i]
 *   value is time - for each v in values() we are getting the rightmost car
 * for each car
 *   put -position and (t-position)/speed
 * define count and slowest time as 0
 * for each value in value set
 *   if v > slowest count++, slowest = v
 * return count
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(-position[i], (double) (target - position[i]) / speed[i]);
        }
        int count = 0;
        double maxTime = 0;
        for (double time : map.values()) {
            if (time > maxTime) {
                maxTime = time;
                count++;
            }
        }
        return count;
    }
}
