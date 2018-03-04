package practice.leetcode.medium;

/**
 * start from 0
 * keep track of remaining gas and distance
 * remain+gas[i] < cost[i],no - remain=0, index=i
 * remain+=(gas[i]-cost[i])
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int distance = 0, remain = 0, index = -1;
        for (int i = 0; i < cost.length; i++) {
            remain += (gas[i] - cost[i]);
            distance += (gas[i] - cost[i]);
            if (remain < 0) {
                remain = 0;
                index = i;
            }
        }
        return distance >= 0 ? index + 1 : -1;
    }
}
