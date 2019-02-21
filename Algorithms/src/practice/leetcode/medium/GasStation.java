package practice.leetcode.medium;

/**
 * @array
 * @greedy
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 *
 * the important concept - if total of the gas > total distance, we will finish the circle for sure
 * initially start from 0
 * keep track of the remaining gas in the tank
 * if remain + gas[i] < cost[i], car will stops in the middle, also means all the stations have visited will not work
 * so update the index as i
 * but the previous stations and remaining should not be ignore
 * use another variable to track total gas remaining
 *
 *
 * keep track of remaining gas and distance
 * remain + gas[i] < cost[i],no - remain=0, index=i
 * remain+=(gas[i]-cost[i])
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int totalGasRemain = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            totalGasRemain += gas[i] - cost[i];
            if (remain < 0) {
                remain = 0;
                index = i + 1;
            }
        }
        return totalGasRemain < 0 ? -1 : index;
    }
}
