package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.Queue;

public class DesignCompressedStringIterator {
}


class StringIterator {
    Queue<int[]> q = new LinkedList<>();
    public StringIterator(String compressedString) {
        q = new LinkedList<>();
        int i = 0;
        int len = compressedString.length();
        while (i < len) {
            int j = i + 1;
            while (j < len && compressedString.charAt(j) - 'A' < 0) { // in ascii table, 0-9 A-Z a-z
                j++;
            }
            q.add(new int[]{compressedString.charAt(i) - 'A',
                    Integer.parseInt(compressedString.substring(i + 1, j))});
            i = j;
        }
    }

    public char next() {
        if (q.isEmpty()) return ' ';
        int[] cur = q.peek();
        if (--cur[1] == 0) q.poll();
        return (char) (cur[0] + 'A');
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}