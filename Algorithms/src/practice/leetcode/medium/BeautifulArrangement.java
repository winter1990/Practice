package practice.leetcode.medium;

/**
 * @array
 * @backtracking
 * @search
 *
 * We define a beautiful arrangement as an array that is constructed by these N numbers successfully
 * if one of the following is true for the ith position (1 <= i <= N) in this array:
 * 1. The number at the ith position is divisible by i.
 * 2. i is divisible by the number at the ith position.
 * given N, how many beautiful arrangements can you construct
 *
 * n=2 [1,2][2,1]
 * n=3 [1,2,3][2,1,3][3,2,1]
 */
public class BeautifulArrangement {
    int cnt = 0;
    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        int[] isUsed = new int[N + 1];
        dfs(N, 1, isUsed);
        return cnt;
    }

    private void dfs(int n, int index, int[] isUsed) {
        if (index > n) {
            cnt++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isUsed[i] == 0 && (i % index == 0 || index % i == 0)) {
                isUsed[i] = 1;
                dfs(n, index + 1, isUsed);
                isUsed[i] = 0;
            }
        }
    }
}
