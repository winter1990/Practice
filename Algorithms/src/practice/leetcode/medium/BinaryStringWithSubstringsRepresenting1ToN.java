package practice.leetcode.medium;

public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String t = Integer.toBinaryString(i);
            if (!S.contains(t)) return false;
        }
        return true;
    }
}
