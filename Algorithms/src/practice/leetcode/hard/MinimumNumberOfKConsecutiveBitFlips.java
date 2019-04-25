package practice.leetcode.hard;

/**
 * @array
 * @bitwise
 *
 * start with first element, slide the window until we see the first
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int index;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                index = i;
                while (index < i + K) {
                    if (index < A.length) {
                        A[index] ^= 1;
                    }
                    index++;
                }
                if (index > A.length) {
                    return -1;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfKConsecutiveBitFlips mk = new MinimumNumberOfKConsecutiveBitFlips();
        int[] in = new int[]{1,1,0};
        System.out.println(mk.minKBitFlips(in, 2));
    }
}
