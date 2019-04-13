package practice.leetcode.easy;

/**
 * @string
 * @greedy
 *
 *
 */
public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int A, int B) {
        if (A > B) {
            return helper(A, 'a', B, 'b');
        }
        return helper(B, 'b', A, 'a');
    }

    private String helper(int ca, char a, int cb, char b) {
        StringBuilder sb = new StringBuilder();
        while (ca-- > 0) {
            sb.append(a);
            if (ca > cb) {
                sb.append(a);
                ca--;
            }
            if (cb-- > 0) {
                sb.append(b);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringWithoutAAAorBBB sw = new StringWithoutAAAorBBB();
        System.out.println(sw.strWithout3a3b(4,9));
    }
}
