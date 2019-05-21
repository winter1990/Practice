package practice.leetcode.hard;

/**
 * @array
 *
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent
 * the same binary value.
 * If it is possible, return any [i, j] with i+1 < j, such that:
 *   A[0], A[1], ..., A[i] is the first part;
 *   A[i+1], A[i+2], ..., A[j-1] is the second part, and
 *   A[j], A[j+1], ..., A[A.length - 1] is the third part.
 *   All three parts have equal binary value.
 *
 * problems to solve:
 * 1. three values should be the same in binary sequence
 * 2. division of the array
 * 3. 0s between two subsequence
 *
 * count 1s in array
 * there might be leading 0s, so start from last and count tailing 0s
 * from back to head, make sure the 0 1 sequence is the same
 * [i,j] -> [0,i][i+1,j-1][j,]
 */
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] A) {
        if (A == null || A.length < 3) return new int[]{-1, -1};
        int total = 0;
        for (int a : A) total += a;
        if (total % 3 != 0) return new int[]{-1, -1};
        int index = A.length - 1;
        int tailingZero = getTailingZeros(A, index);
        index -= tailingZero;
        String binaryNumber = getBinaryNumber(A, index, total / 3);
        index -= binaryNumber.length();
        int p1 = -1, p2 = -1;
        for (int k = 0; k < 2; k++) {
            int a = getTailingZeros(A, index);
            if (p1 == -1 || p2 == -1) {
                if (p1 == -1) {
                    p1 = index - a + tailingZero + 1;
                } else {
                    p2 = index - a + tailingZero;
                }
            }
            index -= a;
            String s = getBinaryNumber(A, index, total / 3);
            index -= s.length();
            if (a < tailingZero || !s.equals(binaryNumber)) return new int[]{-1, -1};
        }
        return new int[]{p2, p1};
    }

    private String getBinaryNumber(int[] a, int index, int ones) {
        StringBuilder sb = new StringBuilder();
        while (ones > 0) {
            sb.insert(0, a[index]);
            if (a[index] == 1) ones--;
            index--;

        }
        return sb.toString();
    }

    private int getTailingZeros(int[] a, int index) {
        int count = 0;
        while (index > 0) {
            if (a[index] == 1) break;
            count++;
            index--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] in = {1,0,1,0,1,0,0};
        ThreeEqualParts t = new ThreeEqualParts();
        t.threeEqualParts(in);
    }

}
