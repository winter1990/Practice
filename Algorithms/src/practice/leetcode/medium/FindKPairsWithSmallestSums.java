package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @array
 * @heap
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * need to track the numbers, so use min heap
 * intuition:
 * use two loops i = [0, m-1] j = [0, n - 1], sum up, put into the heap based on sum
 * poll k pairs in the heap
 *
 * for each number in array 1, the sum is always smallest at index 0 in array 2
 * for each number in array 1, the next candidate pair in array 2 is (the current index in array 2 + 1)
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) q.offer(new int[]{nums1[i], nums2[0], 0});
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

    /**
     * brute force:
     * put all the sum into the min heap and get k pairs
     */
    public List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length ==0 || nums2==null || nums2.length==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new int[]{nums1[i], nums2[j]});
            }
        }
        int size = k <= pq.size() ? k : pq.size();
        for (int i = 0; i < size; i++) res.add(pq.poll());
        return res;
    }
}
