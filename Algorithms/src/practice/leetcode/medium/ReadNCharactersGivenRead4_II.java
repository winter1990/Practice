package practice.leetcode.medium;

public class ReadNCharactersGivenRead4_II {
}

/**
 * @design
 *
 * Your method read may be called multiple times.
 *
 *
 */
class Solution2 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffIdx = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (buffIdx == 0) {
                buffCnt = read4(buff);
            }
            while (index < n && buffIdx < buffCnt) {
                buf[index++] = buff[buffIdx++];
            }
            if (buffIdx == buffCnt) buffIdx = 0;
            if (buffCnt < 4) break;
        }
        return index;
    }
}