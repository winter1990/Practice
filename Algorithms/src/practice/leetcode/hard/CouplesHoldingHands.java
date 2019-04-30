package practice.leetcode.hard;

/**
 * @graph
 * @unionfind
 * @greedy
 *
 * problems to solve:
 * 1. group (2n,2n+1) or (2n+1,2n) for each pair
 * 2. minimize the number of swaps in total
 *
 * use two arrays to track partners and positions:
 * ptn[i] represents the partner of i, ptn[i] = i + 1 if i even, ptn[i] = i if i odd
 * pos[i] represents the index of i in row array, row[pos[i]] = i
 *
 * 1. for the person at index i, the id is row[i], we want to put him next to his partner
 * 2. partner's id is ptn[row[i]]
 * 3. the seat of his partner pos[ptn[row[i]]]
 * 4. the seat next to his partner's seat ptn[pos[ptn[row[i]]]]
 */
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int n = row.length, res = 0;
        int[] ptn = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            ptn[i] = i % 2 == 0 ? i + 1 : i - 1;
            pos[row[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                res++;
            }
        }
        return res;
    }

    private void swap(int[] row, int i, int j) {
        int tmp = row[i];
        row[i] = row[j];
        row[j] = tmp;
    }
}
