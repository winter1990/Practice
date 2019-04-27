package practice.leetcode.medium;

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
        int l = -1, r = -1, n = cs.length;
        for (int i = 0; i <= n; i++) {
            if (i == n || cs[i] == 'R') {
                if (r > l) {
                    while (r < i) cs[r++] = 'R';
                }
                r = i;
            } else if (cs[i] == 'L') {
                if (l > r || (l == -1 && r == -1)) {
                    while (++l < i) cs[l] = 'L';
                } else {
                    l = i;
                    int lo = r + 1, hi = l - 1;
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
        String s = "L.....RR.RL.....L.R.";
        System.out.println(p.pushDominoes(s));
    }
}
