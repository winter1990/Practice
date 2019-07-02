package practice.leetcode.easy;

/**
 * @array
 *
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
 * Then, the answer to the i-th query is the sum of the even values of A.
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]], Output: [8,6,2,4]
 * [1 0]  [2 2 3 4]  - 8
 * [-3 1] [2 -1 3 4] - 6
 * [-4 0] [-2 -1 3 4] - 2
 * [2 3]  [-2 -1 3 6] - 4
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length, even = 0;
        int[] res = new int[n];
        for (int a : A) {
            if (a % 2 == 0) even += a;
        }
        for (int i = 0; i < n; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                if (val % 2 == 0) {
                    even += val;
                } else {
                    even -= A[index];
                }
            } else {
                if (val % 2 != 0) {
                    even += A[index] + val;
                }
            }
            A[index] += val;
            res[i] = even;
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries so = new SumOfEvenNumbersAfterQueries();
        so.sumEvenAfterQueries(new int[]{-1,3,-3,9,-6,8,-5}, new int[][]{{-5,1},{10,2},{-6,3},{3,2},{9,5},{7,5},{8,0}});
    }
}
