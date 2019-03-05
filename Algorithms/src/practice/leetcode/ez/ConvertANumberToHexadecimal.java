package practice.leetcode.ez;

/**
 * @bitwise
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single
 * zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 *
 * hexadecimal -> base 16
 * 26 -> 1a
 *
 *
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal c = new ConvertANumberToHexadecimal();
        int i = -1;
        System.out.println(c.toHex(i));
        System.out.println(Integer.toHexString(i));
    }
}
