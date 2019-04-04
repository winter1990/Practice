package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * Input: A = [1,3,5,4], B = [1,2,3,7] Output: 1, Swap A[3] and B[3]
 *
 * for each element, two options: 1. swap 2. no swap
 * swap[n] means min swaps to make the array [0,n] increasing if we swap a[n] b[n]
 * noswaps[n] means the same if we do not swap a[n] b[n]
 *
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] swap =  new int[n];
        swap[0] = 1;
        int[] noswap = new int[n];
        for (int i = 1; i < n; i++) {
            swap[i] = n;
            noswap[i] = n;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                noswap[i] = noswap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                noswap[i] = Math.min(noswap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], noswap[i - 1] + 1);
            }
        }
        return Math.min(swap[n - 1], noswap[n - 1]);
    }

    public static void main(String[] args) {
        int[] i1 = {1,3,5,4};
        int[] i2 = {1,2,3,7};
        MinimumSwapsToMakeSequencesIncreasing min = new MinimumSwapsToMakeSequencesIncreasing();
        System.out.println(min.minSwap(i1, i2));
    }
}
