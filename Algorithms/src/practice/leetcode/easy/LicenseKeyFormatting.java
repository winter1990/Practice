package practice.leetcode.easy;

/**
 * @string
 *
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
 * except for the first group which could be shorter than K
 *
 * 1. re-group -> remove/trim all the dashes
 * 2. upper case
 * 3. only first group not in k -> len % k, get substring [0, n % k), index += (n % k)
 * 4. for the rest part, add each substring in k
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        S = S.toUpperCase();
        if (S.length() == 0 || K >= S.length()) {
            return S.toUpperCase();
        }
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        int index = 0;
        while (index < n) {
            if (index == 0 && n % K != 0) {
                sb.append(S.substring(index, n % K)).append("-");
                index += (n % K);
            } else {
                sb.append(S.substring(index, index + K)).append("-");
                index += K;
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        LicenseKeyFormatting l = new LicenseKeyFormatting();
        System.out.println(l.licenseKeyFormatting("15F3Z-2acde-9-w", 4));
    }
}
