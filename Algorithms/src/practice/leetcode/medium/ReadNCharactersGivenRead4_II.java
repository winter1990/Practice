package practice.leetcode.medium;

public class ReadNCharactersGivenRead4_II {
}

/**
 * @design
 *
 * Your method read may be called multiple times.
 *
 * we are reading the same file with multiple calls of read(buf[], n)
 * need to keep track of the index for buf, the value of index is the count we have read
 * keep track of the count we want to read, each time we call read(), add to the count
 * to determine we should continue reading, compare index and count - whether file is ended
 *
 *
 */
class Solution2 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;

    public int read(char[] buf, int n) {
        int counter = 0;
        while (counter < n) {
            if (prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if (prevSize == 0) break;
            }
        }
        return counter;
    }

    char[] tmp = new char[4];

}