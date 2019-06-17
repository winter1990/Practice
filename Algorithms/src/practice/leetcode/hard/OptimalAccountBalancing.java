package practice.leetcode.hard;

import java.util.*;

/**
 * A group of friends went on holiday and sometimes lent each other money.
 * For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride.
 * We can model each transaction as a tuple (x, y, z) which means person x gave person y $z.
 * Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID),
 * the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
 * Given a list of transactions between a group of people, return the minimum number of transactions required to settle
 * the debt.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 *
 * Input: [[0,1,10], [2,0,5]] Output: 2
 * Input: [[0,1,10], [1,0,1], [1,2,5], [2,0,5]] Output: 1
 * from to money
 * 0 -> 1  10
 * 1 -> 0   1   0->1 9
 * 1 -> 2   5      1->2 5
 * 2 -> 0   5         2->0 5
 * person #1 only need to give person #0 $4, and all debt is settled
 * p0 10, p1 -10
 * p0  9, p1 -9
 * p1 -4, p2 -5
 * p0  4, p2 0
 * p0 4, p1 -4, p2 0
 *
 * problem to solve:
 * 1. find each person's debt - how much to give/receive
 * 2. find minimum transactions to keep the whole system balanced - each person is 0 debt
 *
 * build up the person -> debt: use a map to track each person's debt - p1 -> p2 x, (p1 +x) (p2, -x)
 * if dept is zero, then not considered, otherwise adding more transactions
 * if paired, two persons debt sum up to 0, then 1 transaction is needed (p1 5) (p2 -5)
 * if not paired:
 *   (p1 8) (p2 3)  (p3 -4) (p4 -5) (p5 -2), [3 -1 -1 -1]
 *   [6 2 9 -4 -5 -8] -> 3, the order to choose value matters
 */
public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) + trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) - trans[2]);
        }
        List<Integer> list = new ArrayList<>();
        for (int d : map.values()) {
            if (d != 0 ) list.add(d);
        }
        Collections.sort(list);
        int pairs = findAndRemovePairs(list);
        int trans = getMinTransactions(list, 0);
        return pairs + trans;
    }

    private int getMinTransactions(List<Integer> list, int start) {
        int res = Integer.MAX_VALUE;
        int n = list.size();
        while (start < n && list.get(start) == 0) start++;
        if (start == n) return 0;
        for (int i = start + 1; i < n; i++) {
            if ((long) list.get(i) * list.get(start) < 0) {
                list.set(i, list.get(i) + list.get(start));
                res = Math.min(res, 1 + getMinTransactions(list, start + 1));
                list.set(i, list.get(i) - list.get(start));
            }
        }
        return res;
    }

    private int findAndRemovePairs(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        int res = 0;
        while (l < r) {
            if (list.get(l) + list.get(r) == 0) {
                res++;
                list.remove(r);
                list.remove(l);
                r -= 2;
            } else if (-list.get(l) > list.get(r)) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing op = new OptimalAccountBalancing();
//        int[][] in = {{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}};
        int[][] in = {{0,1,10}, {1,2,5}, {1,3,3}, {3,1,4}};
        System.out.println(op.minTransfers(in));
    }
}
