package practice.leetcode.medium;

/**
 * @bitwise
 *
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *   For 1-byte character, the first bit is a 0, followed by its unicode code.
 *   For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most
 *   significant 2 bits being 10.
 *
 * 0000 0000
 * 1111 1111 - 255
 * 1000 0000 - 128
 *
 * count the consecutive 1s in first byte
 *   110xxx  1 byte in next
 *   1110xx  2 bytes in next
 *   11110x  3 bytes in next
 *   0xxxxx  0 byte in next, only itself
 *   we count how many bytes we will have
 * else (count != 0)
 *   must start with 10xxxx
 *   then check the head of the number
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int d : data) {
            if (count == 0) {
                if ((d >> 5) == 0b110) {
                    count = 1;
                } else if ((d >> 4) == 0b1110) {
                    count = 2;
                } else if ((d >> 3) == 0b11110) {
                    count = 3;
                } else if ((d >> 7) == 0b1) {
                    return false;
                }
            } else {
                if ((d >> 6) != 0b10) return false;
                count--;
            }
        }
        return count == 0;
    }
}
