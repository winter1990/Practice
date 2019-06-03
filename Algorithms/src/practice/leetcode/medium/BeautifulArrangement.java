package practice.leetcode.medium;

/**
 * @array
 * @backtracking
 *
 * We define a beautiful arrangement as an array that is constructed by these N numbers successfully
 * if one of the following is true for the ith position (1 <= i <= N) in this array:
 *   1. The number at the ith position is divisible by i.
 *   2. i is divisible by the number at the ith position.
 * given N, how many beautiful arrangements can you construct
 *
 * N is a positive integer and will not exceed 15.
 *
 * n = 2, [1,2][2,1]
 * n = 3, [1,2,3][2,1,3][3,2,1]
 *
 * dfs and backtracking
 * start from index [1, n]
 * try to fit [1, n] into the index
 * and for next recursive call, try to fit index 2 until n
 * use an array with size n+1 to track which number is used already
 */
public class BeautifulArrangement {
    public int countArrangement(int N) {
        if (N == 0) return 0;
        boolean[] isUsed = new boolean[N + 1];
        int[] res = new int[1];
        dfs(N, 1, isUsed, res);
        return res[0];
    }

    private void dfs(int n, int index, boolean[] isUsed, int[] res) {
        if (index > n) {
            res[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isUsed[i] && (i % index == 0 || index % i == 0)) {
                isUsed[i] = true;
                dfs(n, index + 1, isUsed, res);
                isUsed[i] = false;
            }
        }
    }

    /**
     * optimization
     * 1. the larger number has the lower chance to find the index
     * 2. swap the elements [1,n] to avoid duplicates
     *
     * start from N, and use an array[n+1] for (index % arr[index]) and (arr[index] % index)
     * place start at N, N-1,...,1 and go to next recursive call
     */
    public int countArrangement1(int N) {
        if (N == 0) return 0;
        int[] a = new int[N + 1];
        for (int i = 1; i <= N; i++) a[i] = i;
        count(a, N);
        return c;
    }

    int c = 0;
    private void count(int[] a, int start) {
        if (start == 0) {
            c++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(a, start, i);
            if (a[start] % start == 0 || start % a[start] == 0) count(a, start - 1);
            swap(a, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
