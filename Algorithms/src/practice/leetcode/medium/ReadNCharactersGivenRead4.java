package practice.leetcode.medium;

public class ReadNCharactersGivenRead4 {
}

class Solution1 extends Reader4 {
    public int read(char[] buf, int n) {
        boolean endOfFile = false;
        int readChar = 0;
        char[] buffer = new char[4];

        while (readChar < n && !endOfFile) {
            int current = read4(buffer);
            if (current != 4) {
                endOfFile = true;
            }
            int len = Math.min(n - readChar, current);
            for (int i = 0; i < len; i++) {
                buf[readChar + i] = buffer[i];
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