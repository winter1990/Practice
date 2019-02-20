package practice.leetcode.medium;

/**
 * @dp
 *
 * on each day, the cost might be included that purchased 7 day or 30 days ago
 * for each day, if we do not need to travel on that day, the cost remains the same
 * otherwise,
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] isTravel = new boolean[366];
        for (int day :days) {
            isTravel[day] = true;
        }
        int[] minCost = new int[366];
        for (int i = 1; i <= 365; i++) {
            if (!isTravel[i]) {
                minCost[i] = minCost[i - 1];
                continue;
            }
            int min;
            min = minCost[i - 1] + costs[0];
            min = Math.min(min, minCost[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, i - 30)] + costs[2]);
            minCost[i] = min;
        }
        return minCost[365];
    }
}
