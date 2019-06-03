package practice.leetcode.easy;

/**
 * @string
 *
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or
 * more times)
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 * get the shorter string
 * divide by 1 2 3 ... n
 * make sure n % i = 0
 * replaceAll() should be ""
 * otherwise return ""
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String s1, String s2) {
        String d = s1.length() < s2.length() ? s1 : s2;
        int n = d.length();
        for (int i = 1; i <= n; i++) {
            if (n % i != 0) continue;
            String sub = d.substring(0, n / i);
            if (s1.replaceAll(sub, "").equals("") && s2.replaceAll(sub, "").equals("")) {
                return sub;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings g = new GreatestCommonDivisorOfStrings();
        System.out.println("s-" + g.gcdOfStrings("LEET",
                "CODE"));
    }
}
