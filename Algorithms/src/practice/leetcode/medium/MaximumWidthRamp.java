package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @array
 *
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].
 * The width of such a ramp is j - i.
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 * Input: [6,0,8,2,1,5] Output: 4
 * Input: [9,8,1,0,1,9,4,0,4,1] Output: 7
 *
 * brute force:
 * N^2 is straightforward
 *
 * optimization:
 * if the it is decreasing, store in the list
 * if the larger element exists compared to the previous element, binary search
 */
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (list.size() == 0 || A[i] < A[list.get(list.size() - 1)]) {
                list.add(i);
            } else {
                int l = 0, r = list.size() - 1, mid = 0;
                while (l < r) {
                    mid = (l + r) / 2;
                    if (A[i] < A[list.get(mid)]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                res = Math.max(res, i - list.get(l));
            }
        }
        return res;
    }

    public int maxWidthRamp1(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) stack.push(i);
        }
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumWidthRamp m = new MaximumWidthRamp();
        int[] in = {6,0,8,2,1,5};
        System.out.println(m.maxWidthRamp(in));
    }
}
