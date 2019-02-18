package practice.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @binarysearch
 * @heap
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.Note that it is the kth smallest element
 * in the sorted order, not the kth distinct element.
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15] k = 8, output = 13
 * which index to search for binary search
 *
 * because increasing in two directions, so we can not do thel inear search by treating the array as 1-D
 * kth - use a heap to store all the previous value
 *
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> q = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            q.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple cur = q.poll();
            if (cur.x == n - 1) {
                continue;
            }
            q.offer(new Tuple(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        return q.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    @Override
    public int compareTo(Tuple t) {
        return this.val - t.val;
    }
}