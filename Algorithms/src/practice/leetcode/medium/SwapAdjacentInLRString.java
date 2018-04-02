package practice.leetcode.medium;

/**
 * either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR"
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * start = "RXXLRXRXL", XRXLRXRXL,XRLXRXRXL,XRLXXRRXL,XRLXXRRLX, true
 */
public class SwapAdjacentInLRString {
    /**
     * thinking of sub sequence
     * XL->LX and RX->XR
     * L can swap with left and R can swap with right
     * count L and R in two strings
     * XL RX XLRX XLXR XRL LXRX
     * LX XR LXXR LRXX RXL XLXR
     * ok ok   ok   ok  no
     *
     * L can move to left until blocked by R
     * R can move to right until blocked by L
     * R can not be negative. if R > 0, L must remain 0
     */
    public boolean canTransform(String start, String end) {
        int r = 0;
        int l = 0;
        for (int i = 0; i < start.length(); i++){
//            if (start.charAt(i) == 'L') l--;
//            if (start.charAt(i) == 'R') r++;
//            if (end.charAt(i) == 'L') l++;
//            if (end.charAt(i) == 'R') r--;
//            if ((l < 0 || r != 0) && (l != 0 || r < 0)) {
//                return false;
//            }

            if (start.charAt(i) == 'L') l++;
            if (start.charAt(i) == 'R') r++;
            if (end.charAt(i) == 'L') l--;
            if (end.charAt(i) == 'R') r--;
            if (l > 0 || r < 0 || (r > 0 && l != 0)) {
                return false;
            }
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
