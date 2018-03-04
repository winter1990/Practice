package practice.leetcode.medium;

/**
 * PAYPALISHIRING
 * PAHNAPLSIIGYIR
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * P    S   G
 * A  I H  N
 * P L  I I
 * A    R
 *
 * row1: (3-1)*2
 * row2: (2-2)*2
 * row3: (3-1)*2
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int block = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                if (i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(j));
                    j += block;
                } else {
                    sb.append(s.charAt(j));
                    if (j + block - 2 * i < s.length()) {
                        sb.append(s.charAt(j + block - 2 * i));
                    }
                    j += block;
                }
            }
        }
        return sb.toString();
    }
}
