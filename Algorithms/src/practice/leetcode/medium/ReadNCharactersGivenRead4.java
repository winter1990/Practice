package practice.leetcode.medium;

/**
 * @design
 *
 * Given a file and assume that you can only read the file using a given method read4,
 * implement a method to read n characters.
 * The return value is the number of actual characters read.
 *
 * n is the number of chars we need to read
 * when we call read4(buffer[]), the actually length is returned and the chars are stored in the buffer[] we pass in
 * two cases:
 *   n > chars in file -> need to determine whether we have read all chars in file -> read4 method < 4
 *     current read4()
 *   n <= chars in file -> read until n
 *     read n - total chars we have read
 * keep track of the chars have been read
 * need a flag to determine if it's end of file
 * need a pointer to copy what we have read by calling read4() into our buffer
 */
public class ReadNCharactersGivenRead4 {
}

class Solution1 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean endOfFile = false;
        int readChar = 0;
        char[] tmp = new char[4];

        while (readChar < n && !endOfFile) {
            int cur = read4(tmp);
            if (cur < 4) endOfFile = true;
            int len = Math.min(n - readChar, cur);
            for (int i = 0; i < len; i++) {
                buf[readChar + i] = tmp[i];
            }
            readChar += len;
        }
        return readChar;
    }

    @Override
    public int read4(char[] buf) {
        return 0;
    }
}