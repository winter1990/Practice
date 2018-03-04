package practice.leetcode.medium;

/**
 * I V	X	L	C	D	M
 * 1 5	10	50	100	500	1,000
 *
 * start from largest
 * minus until 0
 * 9-IV 90-XC
 * map? no.
 * string array => two
 * to handle the the number start with 9, also added
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        while (num != 0) {
            if (val[index] <= num) {
                num -= val[index];
                res.append(rom[index]);
            } else {
                index++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman ir = new IntegerToRoman();
        System.out.println(ir.intToRoman(3999));
    }
}
