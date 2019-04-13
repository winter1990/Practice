package practice.leetcode.easy;

/**
 * @array
 *
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]], Output: [8,6,2,4]
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length;
        int sum = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        int[] res = new int[n];
        int index = 0;
        for (int[] q : queries) {
            if (A[q[1]] % 2 == 0 && q[0] % 2 == 0) {
                sum += q[0];
            } else if (A[q[1]] % 2 == 0 && q[0] % 2 != 0) {
                sum -= A[q[1]];
            } else if (A[q[1]] % 2 != 0 && q[0] % 2 != 0) {
                sum += (A[q[1]] + q[0]);
            }
            A[q[1]] += q[0];
            res[index++] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries so = new SumOfEvenNumbersAfterQueries();
        so.sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}});
    }
}
