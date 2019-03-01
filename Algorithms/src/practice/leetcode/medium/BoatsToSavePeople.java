package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @greedy
 *
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 *
 * sort the weight array first
 * put heaviest in boat first then fill in the lightest
 *
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int s = 0, e = people.length - 1;
        while (s <= e) {
            if (people[s] + people[e] <= limit) {
                s++;
            }
            e--;
        }
        return people.length - 1 - e;
    }
}
