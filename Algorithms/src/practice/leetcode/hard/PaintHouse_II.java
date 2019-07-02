package practice.leetcode.hard;

/**
 * @dp
 * @array
 *
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1
 * with color 2, and so on...
 *
 * Find the minimum cost to paint all houses.
 *
 *
 */
public class PaintHouse_II {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        if(k == 1) return (n==1? costs[0][0] : -1);

        int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
        for(int i = 0; i<n; i++) {
            int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
            for(int j = 0; j<k;  j++) {
                int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
                if(minInd< 0) {min = val; minInd = j;}//when min isn't initialized
                else if(val < min) {//when val < min,
                    secMin = min;
                    min = val;
                    minInd = j;
                } else if(val < secMin) { //when min<=val< secMin
                    secMin = val;
                }
            }
            prevMin = min;
            prevMinInd = minInd;
            prevSecMin = secMin;
        }
        return prevMin;
    }

    /**
     * To solve this DP problem:
     *
     * If there's no constraint, we choose min cost for each house.
     * Since house[i] and house[i - 1] cannot have the same color j, we should choose 2nd min color for house[i - 1].
     * If we choose the 3rd min color for house[i - 1], we might miss potential min cost.
     * min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n.
     * Since current row only relies on last row for getting mins and avoiding same color, O(1) space is enough.
     */
    public int minCostII1(int[][] costs) {
        if (costs.length == 0) return 0;
        int min1 = 0, min2 = 0, index1 = -1;
        for (int i = 0; i < costs.length; i++) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;
            for (int j = 0; j < costs[0].length; j++) {
                int cost = costs[i][j] + (j != index1 ? min1 : min2);
                if (cost < m1) {           // cost < m1 < m2
                    m2 = m1; m1 = cost; idx1 = j;
                } else if (cost < m2) {    // m1 < cost < m2
                    m2 = cost;
                }
            }
            min1 = m1; min2 = m2; index1 = idx1;
        }
        return min1;
    }
}
