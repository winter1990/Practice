package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @array
 * @heap
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * need to track the numbers, so use min heap
 * for each number in array 1, the sum is always smallest at index 0 in array 2
 *
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums f = new FindKPairsWithSmallestSums();
        int[] i1 = {1,1,2};//{1,1,2};//{1,7,11};
        int[] i2 = {1,2,3};//{1,2,3};//{2,4,6};
        System.out.println(f.kSmallestPairs(i1, i2, 10));
    }
}
