package practice.interview.google;

/**
 * Apply one permutation to another. Assume you have an array A of length n, and you have a permutation array P of
 * length n as well. Your method will return an array where elements of A will appear in the order with indices
 * specified in P.
 * Example: A = [a, b, c, d, e] P = [4, 3, 2, 0, 1].
 * Output: [d e c b a]
 */
public class ApplyPermutation {
    public char[] permute(char[] A, int[] P) {
        for (int i = 0; i < A.length; i++) {
            while (P[i] != i) {
                char tmpChar = A[i];
                A[i] = A[P[i]];
                A[P[i]] = tmpChar;

                int tmpInt = P[i];
                P[i] = P[P[i]];
                P[tmpInt] = tmpInt;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        char[] a = {'a','b','c','d','e'};
        int[] p = {4,3,2,0,1};
        ApplyPermutation ap = new ApplyPermutation();
        char[] res = ap.permute(a, p);
        for (char c : res) System.out.print(c + " ");
    }
}
