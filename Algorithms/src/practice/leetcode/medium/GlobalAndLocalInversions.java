package practice.leetcode.medium;

/**
 * 1 0 2 true, global and local 1>0
 * 1 2 0 false global 1>0 2>0 local 2>0
 *
 * if it's local, it must be global
 * so only consider the numbers
 */
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int max = -1;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);
            if (max > A[i + 2]) {
                return false;
            }
        }
        return true;
    }
}
