package practice.leetcode.ez;

/**
 * @string
 *
 * for each character, if it is between A and Z, then convert it to lower case
 * c - 'A' + 'a'
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'A' && cs[i] <= 'Z') {
                cs[i] = (char)(cs[i] - 'A' + 'a');
            }
        }
        return new String(cs);
    }
}
