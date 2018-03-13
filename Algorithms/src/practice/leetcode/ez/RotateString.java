package practice.leetcode.ez;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        return (A + A).indexOf(B) >= 0;
    }
}
