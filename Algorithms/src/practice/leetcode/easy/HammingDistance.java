package practice.leetcode.easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int c = 0;
        while (diff != 0) {
            c += diff & 1;
            diff >>= 1;
        }
        return c;
    }

    public int hammingDistance1(int x, int y) {
        int diff = x ^ y;
        int c = 0;
        for (int i = 0; i < 32; i++) {
            c += diff & 1;
            diff >>= 1;
        }
        return c;
    }
}
