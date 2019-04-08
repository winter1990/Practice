package practice.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @array
 * @heap
 *
 * hire exactly K workers to form a paid group
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * Return the least amount of money needed to form a paid group satisfying the above conditions.
 *
 * Input: quality = [10,20,5], wage = [70,50,30], K = 2 Output: 105.00000 -> 0th is 70, so 2nd is 35
 * Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3 Output: 30.66667 -> 0th 2nd 3rd
 * example 1 - unit wage [7 2.5 6] -> 1 and 2, 30 + math.max(50, 30*3) = 120, so cheapest per unit does not mean best
 * example 2 - unit wage [4/3 8 5 5 7]
 *
 * 1. sort by wage/quality -> w[i] : w[j] = q[i] : q[2] -> w[i] : q[i] = w[j] : q[j]
 * 2. the quality becomes the bottle neck for total cost -> get the largest quality from current, and put next cheapest
 * 3. use an array[] to store and sort the wage/quality and quality
 * 4. cost = min unit wage * total quality, keep track of it
 * 5. start with smallest unit wage, we need to get top k
 *      update total
 *      put quality into the heap
 *      if there are more than k workers, we need to take out the largest quality one from heap
 *        (go back to step 3 - we also need the quality value in the array -> arr[][])
 *        update total
 *      if workers = k, update min = math.min(min, current unit wage * total quality
 *
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
