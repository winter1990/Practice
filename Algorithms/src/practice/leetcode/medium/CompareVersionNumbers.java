package practice.leetcode.medium;

/**
 * @String
 * @array
 *
 * compare version:
 * version1 = "0.1", version2 = "1.1", Output: -1
 * version1 = "1.0.1", version2 = "1", Output: 1
 * version1 = "7.5.2.4", version2 = "7.5.3", Output: -1
 * version1 = "1.01", version2 = "1.001", Output: 0 ignore the leading 0s
 * version1 = "1.0", version2 = "1.0.0", Output: 0
 *
 * problems to solve:
 * 1. find the mechanism to compare two versions - how to compare values
 * 2. corner cases - leading 0, extra fields with 0
 *
 * split the string by dot
 *   get two string array
 *   they may have different lengths
 * start with index 0, if over the length for any of them, make it zero
 * get the value of string and compare
 *   if any of them is larger than other, no need to continue comparing
 *     if v1 > v2, return 1
 *     if v1< v2, return -1
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
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
