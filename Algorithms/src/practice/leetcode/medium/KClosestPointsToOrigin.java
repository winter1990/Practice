package practice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @heap
 * @daq
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * method 1
 * the distance to the original points -> sqrt(p[0]^2 + p[1]^2)
 * define the comparator, sort the points based on distance
 * time O(NlogN)
 * we sort all the points which is unnecessary
 *
 * method 2
 * maintain a heap with size of K
 * max or min heap? we want the smallest K points in the heap
 * so when size of heap > K, we want to poll the largest from the heap -> use max heap
 * time O(NlogK)
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) pq.poll();
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) res[i] = pq.poll();
        return res;
    }

    /**
     * @quickselect
     * similar with quick select
     * pick a pivot - pick an element
     */
    public int[][] kClosest3(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = partition(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    public int[][] kClosest4(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l < r) {
            int index = partitionPoints(points, l, r);
            if (index == K) {
                break;
            } else if (index < K) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partitionPoints(int[][] a, int start, int end) {
        int index = start + new Random().nextInt(end - start + 1);
        int[] pivot = a[index];
        swap(a, index, end);
        int l = start, r = end - 1;
        while (l <= r) {
            while (l <= r && !isFurther(a[l], pivot)) l++;
            while (l <= r && isFurther(a[r], pivot)) r--;
            if (l <= r) {
                swap(a, l, r);
                l++;
                r--;
            }
        }
        swap(a, l, end);
        return l;
    }

    private boolean isFurther(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] > p2[0] * p2[0] + p2[1] * p2[1];
    }

    private void swap(int[][] a, int i, int j) {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,3},{-2,2}};
        KClosestPointsToOrigin k = new KClosestPointsToOrigin();
        System.out.println(k.kClosest4(in, 1));
    }
}