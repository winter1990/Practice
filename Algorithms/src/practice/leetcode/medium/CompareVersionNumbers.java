package practice.leetcode.medium;

/**
 * @String
 *
 * compare version:
 * 12.34.567
 * 12.333.789
 * 13.1
 * 13.1.1
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);

        for (int i = 0; i < len; i++) {
            int val1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int val2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            }
        }
        return 0;
    }
}
