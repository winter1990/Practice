package practice.leetcode.question;

/**
 * @string
 *
 * Input: ".L.R...LR..L..", Output: "LL.RR.LLRRLL.."
 * Input: "RR.L", Output: "RR.L"
 *
 * .L.R...LR..L..  ->  LL.RR.LLRRLL..
 * 00012340123000
 *
 * all cases:
 * R...R -> RRRRR
 * R...L -> RR.LL
 * R....L -> RRRLLL
 * L...R -> L...R
 * L...L -> LLLLL
 *
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int L = -1, R = -1;
        for (int i = 0; i <= dominoes.length(); i++) {
            if (i == cs.length || cs[i] == 'R') {
                if (R > L) {
                    while (R < i) cs[R++] = 'R';
                }
                R = i;
            } else if (cs[i] == 'L') {
                if (L > R || (R == -1 && L == -1)) {
                    while (++L < i) cs[L] = 'L';
                } else {
                    L = i;
                    int lo = R + 1, hi = L - 1;
                    while (lo < hi) {
                        cs[lo++] = 'R';
                        cs[hi--] = 'L';
                    }
                }
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        PushDominoes p = new PushDominoes();
        String s = "..L..L";
        System.out.println(p.pushDominoes(s));
    }
}
