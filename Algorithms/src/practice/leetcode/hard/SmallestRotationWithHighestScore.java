package practice.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
any entries that are less than or equal to their index are worth 1 point
Input: [2, 3, 1, 4, 0], Output:3
             0 1 2 3 4
K = 0,  A = [2,3,1,4,0],    score 2
K = 1,  A = [3,1,4,0,2],    score 3
K = 2,  A = [1,4,0,2,3],    score 3
K = 3,  A = [4,0,2,3,1],    score 4
K = 4,  A = [0,2,3,1,4],    score 3
A[i] will be in the range [0, A.length].
 */

/**
 * how to get point?
 * how to lose point?
 *
 * to lose point, we need to rotate K where K > (i-A[i]+1)%n
 * which means if we rotate K times to left, A[i] will be at the position A[i], we can get the point
 *
 */
public class SmallestRotationWithHighestScore {
    public int bestRotation1(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int n = A.length;
        int[] change = new int[n];
        for (int i = 0; i < n; i++) {
            change[(i - A[i] + 1 + n) % n] -= 1;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            change[i] += change[i - 1] + 1;
            max = change[i] > change[max] ? i : max;
        }
        return max;
    }

    public static void main(String[] args) {
        SmallestRotationWithHighestScore s = new SmallestRotationWithHighestScore();
        int[] arr = {2, 3, 1, 4, 0};
        System.out.println(s.bestRotation1(arr));
    }
}
