package practice.leetcode.medium;

/**
 * @math
 *
 * 0 <= q <= p
 *
 * vertically, each time the light will always move q distance - same direction up or down and up & down
 * in horizon direction, each time it must move p
 * condition to hit 0: 3q - 2p
 * condition to hit 1: 1q - 1p, need odd reflections
 * condition to hit 2: 2q - 1p, need even reflections
 * keep adding q to current
 *
 * __________________________
 * |    |    |    |0   |    |0
 * |    |    |    |1   |2   |
 * --------------------------
 * |2   |1   |2   |1   |2  1|
 * |    |    |    |    |    |
 * --------------------------
 * st   0
 * to reach 1, 1 3 5
 * to reach 2, 2 4 6
 * to reach 0, 3/2 5/2
 */
public class MirrorReflection {
    public int mirrorReflection1(int p, int q) {
        int cur = 0;
        for (int i = 1; ; i++) {
            cur += q;
            cur %= 2 * p;
            if (cur == 0) {
                return 0;
            }
            if (cur == p) {
                if (i % 2 == 1) {
                    return 1;
                }
                return 2;
            }
        }
    }

    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (p % 2 == 0) {
            return 2;
        } else if (q % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
