package practice.leetcode.ez;

/**
 * We have two special characters.
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * [1, 0, 0] true
 * [1, 1, 1, 0] false
 *
 */
public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        int n = bits.length;
        while (index < n) {
            if (bits[index] == 1) {
                index += 2;
                if (index == n) {
                    return false;
                }
            } else {
                index++;
            }
        }
        return true;
    }
}
