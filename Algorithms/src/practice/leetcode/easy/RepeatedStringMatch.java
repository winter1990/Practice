package practice.leetcode.easy;

/**
 * @string
 *
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.
 *
 * what is the minimum time needs to be repeated
 * A=abcde  B=de abcde abcde abcde ab
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch1(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B)) return count;
        return sb.append(A).toString().contains(B) ? count + 1 : -1;
    }

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        int count = 1;
        while (sb.indexOf(B) == -1) {
            if (sb.length() - A.length() > B.length()) {
                return -1;
            }
            sb.append(A);
            count++;
        }
        return count;
    }
}
