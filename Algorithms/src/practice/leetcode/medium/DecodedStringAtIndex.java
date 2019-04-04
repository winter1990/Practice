package practice.leetcode.medium;

/**
 * @string
 *
 * the encoded string is read one character at a time and the following steps are taken:
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 *
 * Input: S = "leet2code3", K = 10, Output: "o"
 * decoded string: leet -> leetleet -> leetleetcode -> leetleetcodeleetleetcodeleetleetcode
 * Input: S = "ha22", K = 5, Output: "h"
 * decoded string: ha -> haha -> hahahaha
 *
 * intuition:
 * get the whole string and get the k-th character
 *
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        char c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) len *= (c - '0');
            if (Character.isLetter(c)) len++;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                len /= (c - '0');
                K %= len;
            } else {
                if (K == 0 || K == len) return c + "";
                len--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "a2345678999999999999999";
        int k = 1;
        DecodedStringAtIndex d = new DecodedStringAtIndex();
        System.out.println(d.decodeAtIndex(s, k));
    }
}
