package practice.interview.google;

import java.util.PriorityQueue;

/**
 * by A and B, one for each, price is given
 * what is the minimum price to buy 1A and 1B
 * {1,10},{50,60},{100,200}
 */
public class BuyProductFromTwoCompany {
    public int minCost1(int[][] cost) {
        if (cost.length <= 1) return 0;
        PriorityQueue<int[]> qa = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        PriorityQueue<int[]> qb = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < cost.length; i++) {
            qa.offer(new int[]{cost[i][0], i});
            qb.offer(new int[]{cost[i][1], i});
            if (qa.size() > 2) qa.poll();
            if (qb.size() > 2) qb.poll();
        }
        int[] a1 = qa.poll(), a2 = qa.poll();
        int[] b1 = qb.poll(), b2 = qb.poll();
        if (a2[1] != b2[1]) return a2[0] + b2[0];
        return Math.min(a1[0] + b2[0], a2[0] + b1[0]);
    }

    public static void main(String[] args) {
        int[][] in = {{1,10},{50,60},{100,200}};
        BuyProductFromTwoCompany b = new BuyProductFromTwoCompany();
        System.out.println(b.minCost1(in));
    }
}
