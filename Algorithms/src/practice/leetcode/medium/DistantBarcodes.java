package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @array
 *
 * In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
 * Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is
 * guaranteed an answer exists.
 *
 * count each barcode's frequency
 * start with the largest to fill in the array
 *
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int b : barcodes) map.put(b, map.getOrDefault(b, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue() == 0 ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) pq.offer(e);
        int[] res = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> first = pq.poll();
            res[i++] = first.getKey();
            if (!pq.isEmpty()) {
                Map.Entry<Integer, Integer> second = pq.poll();
                res[i++] = second.getKey();
                if (second.getValue() > 1) {
                    second.setValue(second.getValue() - 1);
                    pq.offer(second);
                }
            }
            if (first.getValue() > 1) {
                first.setValue(first.getValue() - 1);
                pq.offer(first);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {1,2,2,1,1,2};
        DistantBarcodes d = new DistantBarcodes();
        d.rearrangeBarcodes(in);
    }
}
