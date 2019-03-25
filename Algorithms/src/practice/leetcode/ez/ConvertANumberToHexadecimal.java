package practice.leetcode.ez;

/**
 * @bitwise
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single
 * zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 *
 * The two's complement of an N-bit number is defined as its complement with respect to 2N.
 * For instance, for the three-bit number 010, the two's complement is 110, because 010 + 110 = 1000.
 *
 * hexadecimal -> base 16
 * 0 1 2 3 4 5 6 7 8 9 a b c d e f(15) 10(16)
 * build an array as the map
 * while num is not 0, % 16
 * get the character in array
 *
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String res = "";
        while (num != 0) {
            res = map[num & 10] + res;
            num = (num >>> 4);
        }
        return res;
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal c = new ConvertANumberToHexadecimal();
        int i = -1;
        System.out.println(c.toHex(i));
    }
}
