package practice.leetcode.ez;

public class RepeatedStringMatch {
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
