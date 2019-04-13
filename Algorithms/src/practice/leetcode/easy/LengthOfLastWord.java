package practice.leetcode.easy;

/**
 * @string
 *
 * "hello world" => 5
 * A word is defined as a character sequence consists of non-space characters only.
 *
 * trim(), then count from last index
 *
 * two scenarios: space or non-space
 * the key point: we see a space? or we see non-space? for this case, definitely the space is the condition to check
 * if we see space, check count:
 * 1) count != 0, means we have counted the whole last word, then step out loop
 * 2) count == 0, means we have not seen the non-empty word, continue
 *
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int index = s.length() - 1;
        while (index >= 0) {
            if (s.charAt(index) == ' ' && count != 0) {
                break;
            } else if (s.charAt(index) == ' ' && count == 0) {
                index--;
            } else {
                index--;
                count++;
            }
        }
        return count;
    }
}
