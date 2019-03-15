package practice.leetcode.medium;

/**
 * @array
 *
 * from first string to last string, check the character 1 by 1 vertically
 */
public class DeleteColumnsToMakeSorted_II {
    public int minDeletionSize(String[] A) {
        int res = 0;
        boolean[] isSorted = new boolean[A.length - 1];
        for (int i = 0; i < A[0].length(); i++) {
            int row = 0;
            for (; row < A.length - 1; row++) {
                if (!isSorted[row] && A[row].charAt(i) > A[row + 1].charAt(i)) {
                    res++;
                    break;
                }
            }
            if (row < A.length - 1) continue;

            for (int k = 0; k < A.length - 1; k++) {
                if (A[k].charAt(i) < A[k + 1].charAt(i)) isSorted[k] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted_II d = new DeleteColumnsToMakeSorted_II();
        String[] ss = {"xga","xfb","yfa"};
        System.out.println(d.minDeletionSize(ss));
    }
}
