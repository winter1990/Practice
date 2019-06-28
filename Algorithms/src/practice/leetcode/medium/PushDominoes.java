package practice.leetcode.medium;

/**
 * @string
 *
 * There are N dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * Return a string representing the final state.
 *
 * Input: ".L.R...LR..L..", Output: "LL.RR.LLRRLL.."
 * Input: "RR.L", Output: "RR.L"
 *
 * .L.R...LR..L..  ->  LL.RR.LLRRLL..
 * 00012340123000
 *
 * all cases:
 * R...R -> RRRRR
 * L...R -> L...R
 * R...L
 *   odd dominoes between  R...L -> RR.LL
 *   even dominoes between R....L -> RRRLLL
 * L...L -> LLLLL
 *
 * keep track the position of l and r
 * i = [0, n-1]
 *   if L
 *     if R = -1 and L= -1, push all to left
 *     if R != -1, while(L<R) R++ L-- update L and R
 *   else if R
 *     if L<R, from R to i, all R
 *     else leave it
 * at last deal with tail
 *   let i = [0, n]
 *   the condition for checking 'R is changed to (i == n || cs[i] == 'R')
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int l = -1, r = -1, n = dominoes.length();
        char[] res = dominoes.toCharArray();
        for (int i = 0; i <= n; i++) {
            if (i == n || res[i] == 'R') {
                if (r > l) {
                    while (++r < i) res[r] = 'R';
                }
                r = i;
            } else if (res[i] == 'L') {
                if (l > r || (r == -1 && l == -1)) {
                    while (++l < i) {
                        res[l] = 'L';
                    }
                } else {
                    int lo = r + 1;
                    int hi = i - 1;
                    while (lo < hi) {
                        res[lo++] = 'R';
                        res[hi--] = 'L';
                    }
                    l = i;
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        PushDominoes p = new PushDominoes();
        String s = "L.....RR.RL.....L.R.";
        System.out.println(p.pushDominoes(s));
    }
}
