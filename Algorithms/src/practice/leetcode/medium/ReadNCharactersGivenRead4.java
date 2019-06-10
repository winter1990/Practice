package practice.leetcode.medium;

/**
 * @design
 *
 * Given a file and assume that you can only read the file using a given method read4,
 * implement a method to read n characters.
 *
 * The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.
 *
 * The return value is the number of actual characters read.
 *
 * By using the read4 method, implement the method read that reads n characters from the file and store it in the buffer
 * array buf. Consider that you cannot manipulate the file directly.
 * Note: buf[] is destination not source, you will need to write the results to buf[]
 *
 * The return value is the number of actual characters read.
 *
 * -----------------------
 *
 * n is the number of chars we need to read
 * when we call read4(buffer[], n)
 *   buffer size is not known
 *   the chars are stored in the buffer[] we pass in
 *   the actually length should be returned
 *   total n chars we want to read
 *
 * two cases when calling read4 method:
 *   return 4 - there are chars left in the file
 *   return < 4 - we have read all chars in the file
 * two cases when calling read method:
 *   we read n chars
 *   less than n chars
 *
 * whether we should continue calling read4(buf[]) is determined by:
 *   whether file is end
 *   whether we have read n chars
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