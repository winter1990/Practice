package practice.leetcode.ez;

/**
 * @string
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
        System.out.println(l.licenseKeyFormatting("15F3Z-2e-9-w", 4));
    }
}
