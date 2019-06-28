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
 *
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers
 * -> wage[i]/wage[j] = quality[i]/quality[j]
 * -> wage[i]/quality[i] = wage[j]/quality[j]
 *
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * -> in the group, the wage of total is determined by which person?
 * -> if we choose small w1/q1 and there exists a larger w2/q2 > w1/q1, it violates the rule, so need to decrease w2
 * -> the group is determined by largest w[i]/q[i]
 *
 * conclusion
 * -> for each person, calculate w[i]/q[i]
 * -> total wage is - largest w[i]/q[i] * (total quality)
 * -> if another person comes in, factor of w[i]/q[i] is larger
 * -> we want to make the total wage smaller, we need to make the (total quality) factor smaller
 * -> so need to take the largest quality person out of group
 * -> keep track of the smallest total cost
 *
 * need to figure out how wage and quality may affect the total cost
 *   smaller wage[i] - less cost
 *   larger wage[i] - more cost
 *   small quality[i] - set the minimal threshold [5 1] [10 10]
 *     total cost = wage[i] * (total quality / q[i])
 *     so smaller quality means in the paid group, it is setting the minimal threshold higher
 *   so we want low wage with high quality
 *   sort by wage[i]/quality[i]
 * after choosing the min ratio, get the largest quality from current
 *
 * we need to track the wage[i]/quality[i], and quality[i]
 *   use an array[] to store and sort the wage/quality and quality
 *   cost = min unit wage * total quality
 * start with smallest unit wage, we need to get top k
 *    update total
 *    put quality into the heap
 *    if there are more than k workers, we need to take out the largest quality one from heap
 *      (go back to step 3 - we also need the quality value in the array -> arr[][])
 *      update total
 *    if workers = k, update min = math.min(min, current unit wage * total quality
 *
 */
public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        double[][] ratios = new double[n][2];
        for (int i = 0; i < n; i++) {
            ratios[i] = new double[]{(double) wage[i] / quality[i], (double) quality[i]};
        }
        Arrays.sort(ratios, (a, b) -> Double.compare(a[0], b[0]));
        double min = Double.MAX_VALUE, total = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] d : ratios) {
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
