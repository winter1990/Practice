package practice.leetcode.easy;

/**
 * @string
 * @math
 *
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF,
 * and has a shorthand (that is, it can be represented as some "#XYZ"
 *
 * Input: color = "#09f166"
 * Output: "#11ee66" - similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 *
 * 09, 11 is closest to 09
 * f1=16*15+1, ee=16*14+14
 * 66, 66
 *
 * whether we should choose bigger or smaller number depends on second digit
 * 11=17 22=34 33=51 44=68...
 * 18=16+8=24 24%17=7 7<16 so it's closer to the 'lower number'
 * 19=25 % 17 = 8
 * 1a=26 % 17 = 9
 * number%17 must be bigger than 8
 */
public class SimilarRGBColor {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < color.length(); i += 2) {
            String s = getMostSimilarDigit(color.substring(i, i + 2));
            sb.append(s);
        }
        return sb.toString();
    }

    private String getMostSimilarDigit(String s) {
        int a = Character.isDigit(s.charAt(0)) ? s.charAt(0) - '0' : 10 + (s.charAt(0) - 'a');
        int b = Character.isDigit(s.charAt(1)) ? s.charAt(1) - '0' : 10 + (s.charAt(1) - 'a');
        int num = a * 16 + b;
        int val = num / 17;
        int remainder = num % 17;
        if (remainder > 8) {
            val += 1;
        }
        char c = val <= 9 ? (char)('0' + val) : (char)('a' + val - 10);
        return String.valueOf(c) + String.valueOf(c);
    }

    public static void main(String[] args) {
        SimilarRGBColor ss = new SimilarRGBColor();
        String s = "#09f166";
        System.out.println(ss.similarRGB(s));
    }
}
