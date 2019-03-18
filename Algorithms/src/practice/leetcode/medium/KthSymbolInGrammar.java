package practice.leetcode.medium;

/**
 * @string
 *
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence
 * of 0 with 01, and each occurrence of 1 with 10.
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 *
 * 1 0
 * 2 01
 * 3 0110
 * 4 01101001
 * 5 0110100110010110
 *
 * more observation:
 * number of 1s -> 2^(N-1)
 *
 * decimal  0  1   2   3   4   5   6   7    8    9   10   11
 * binary   0  0  10  11 100 101 110 111 1000 1001 1010 1011
 * 1s       0  1   1   2   1   2   2   3    1    2    2    3
 * ev/odd   e  o   o   e   o   e   e   o    o    e    e    o
 * sequence 0  1   1   0   1   0   0   1    1    0    0    1
 */
public class KthSymbolInGrammar {
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }
    /**
     * java.lang.OutOfMemoryError: Java heap space
     */
    public int kthGrammar1(int N, int K) {
        K -= 1;
        String str = getNthStr("0", N);
        return str.charAt(K) - '0';
    }

    private String getNthStr(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(s.charAt(j) == '0' ? "01" : "10");
            }
            s = sb.toString();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        KthSymbolInGrammar ks = new KthSymbolInGrammar();
        System.out.println(ks.kthGrammar(30, 434991989));
    }
}
