package practice.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @array
 *
 * hire exactly K workers to form a paid group
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * Return the least amount of money needed to form a paid group satisfying the above conditions.
 * Input: quality = [10,20,5], wage = [70,50,30], K = 2 Output: 105.00000 -> 0th is 70, so 2nd is 35
 * Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3 Output: 30.66667 -> 0th 2nd 3rd
 *
 * for two workers: w[i] : w[j] = q[i] : q[2] -> w[i] : q[i] = w[j] : q[j]
 * example 1 - [7 2.5 6]
 * example 2 - [1.3 8 5 5 7]
 *
 * we want to minimize the total pay -> small w[i] : q[i]
 * use a min heap, get top K
 * each time we remove the largest quality as it is the bottle neck for total ratio
 * maintain a heap with size K
 * repeat the process and update min
 */
public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[][] work = new double[n][2];
        for (int i = 0; i < n; i++) work[i] = new double[]{(double) wage[i] / quality[i], (double)quality[i]};
        Arrays.sort(work, (a, b) -> Double.compare(a[0], b[0]));
        double min = Double.MAX_VALUE, total = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] d : work) {
            pq.offer(-d[1]);
            total += d[1];
            if (pq.size() > K) total += pq.poll();
            if (pq.size() == K) min = Math.min(min, total * d[0]);
        }
        return min;
    }

    public static void main(String[] args) {
//        int[] quality = {3,1,10,10,1}, wage = {4,8,2,2,7};
        int[] quality = {10,20,5}, wage = {70,50,30};
        int k = 2;
        MinimumCostToHireKWorkers m = new MinimumCostToHireKWorkers();
        System.out.println(m.mincostToHireWorkers(quality, wage, k));
    }
}
