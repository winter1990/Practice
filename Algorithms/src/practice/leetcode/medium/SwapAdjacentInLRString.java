package practice.leetcode.medium;

/**
 * @string
 *
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one
 * occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR".
 * Given the starting string start and the ending string end, return True if and only if there exists a sequence
 * of moves to transform one string to the other.
 *
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * start = "RXXLRXRXL", XRXLRXRXL,XRLXRXRXL,XRLXXRRXL,XRLXXRRLX, true
 *
 * thinking of sub sequence
 * two operations we can do:
 *   XL -> LX
 *   RX -> XR
 * L can swap with left X and R can swap with right X
 *
 * R...L
 * L blocks R to go right
 * R blocks L to go left
 *
 * L...R
 * they do not block each other
 *
 * L and R in start and end
 * R in end can be after the R in start, no blocking
 * L in end can be before the L in start, no blocking
 *
 * so count L and R in two strings
 * XL RX XLRX XLXR XRL LXRX
 * LX XR LXXR LRXX RXL XLXR
 * ok ok   ok   ok  no   no
 *
 * L can move to left until blocked by R
 * R can move to right until blocked by L
 *
 * for start, if:
 *   s[i] = l, l++
 *   s[i] = r, r++
 * for end, if:
 *   e[i] = l, l--
 *   e[i] = r, r--
 * basic case
 *   l > 0 false
 *   r < 0 false
 * L and R have collision
 *   r > 0 and l < 0
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        int r = 0, l = 0;
        for (int i = 0; i < start.length(); i++){
            if (start.charAt(i) == 'L') {
                l++;
            } else if (start.charAt(i) == 'R') {
                r++;
            }
            if (end.charAt(i) == 'L') {
                l--;
            } else if (end.charAt(i) == 'R') {
                r--;
            }
            if (l > 0 || r < 0 || (r > 0 && l < 0)) return false;
        }
        return l == 0 && r == 0;
    }

    public static void main(String[] args) {
        String a1 = "XXRXXLXXXX";
        String a2 = "XXXXRXXLXX";
        String b1 = "RXXLRXRXL";
        String b2 = "XRLXXRRLX";
        String c1 = "RL";
        String c2 = "LR";
        String d1 = "XXXLXRXX";
        String d2 = "LXXXXXXR";
        String f1 = "XXLXXXR";
        String f2 = "LXXXRXX";
        String e1 = "XXLRXX";
        String e2 = "LXXXXR";
        SwapAdjacentInLRString s = new SwapAdjacentInLRString();
        System.out.println(s.canTransform(a1, a2)); // f
        System.out.println(s.canTransform(b1, b2)); // t
        System.out.println(s.canTransform(c1, c2)); // f
        System.out.println(s.canTransform(d1, d2)); // t
        System.out.println(s.canTransform(f1, f2)); // f
        System.out.println(s.canTransform(e1, e2)); // t
    }
}
