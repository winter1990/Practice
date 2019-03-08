package practice.leetcode.ez;

/**
 * Given an array of characters, compress it in-place.
 * return the new length of the array
 *
 * two pointers:
 * i is index for replacement
 * j is the counter
 * only count>=2, compress
 * [abcccaa] -> [abc3a2] -> 6
 * [abbbbbbbbbb] -> ['a','b','1','0']
 */
public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0, n = chars.length;
        while (j < n) {
            char c = chars[j];
            int count = 0;
            while (j < n && chars[j] == c) {
                count++;
                j++;
            }
            chars[i] = c;
            i++;
            if (count != 1) {
                for (char digit : ("" + count).toCharArray()) {
                    chars[i++] = digit;
                }
            }
        }
        return i;
    }

    public int compress1(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }

        int i = 0;
        for (int j = 0, c = 0; j < chars.length; j++) {
            c++;
            if (j == chars.length - 1 || chars[j] != chars[j + 1]) {
                chars[i] = chars[j];
                i++;
                if (c != 1) {
                    char[] cs = String.valueOf(c).toCharArray();
                    for (int k = 0; k < cs.length; k++) {
                        chars[i] = cs[k];
                        i++;
                    }
                }
                c = 0;
            }
        }
        return i;
    }
}
