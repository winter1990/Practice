package practice.leetcode.medium;

/**
 * @string
 * @greedy
 *
 * find the lexicographically smallest permutation of [1, 2, ... n] could refer to
 * the given secret signature in the input.
 * 123
 * DI
 * 213
 * 123456
 * DIDDI
 * 215436
 *
 */
public class FindPermutation {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = i + 1;
        }
        int left = 0;
        int right = 0;
        while (right < n) {
            if (s.charAt(right) == 'D') {
                left = right;
                while (right < n && s.charAt(right) == 'D') {
                    right++;
                }
                reverse(res, left, right);
            }
            right++;
        }
        return res;
    }

    private void reverse(int[] res, int left, int right) {
        while (left < right) {
            int tmp = res[left];
            res[left] = res[right];
            res[right] = tmp;
            left++;
            right--;
        }
    }
}
