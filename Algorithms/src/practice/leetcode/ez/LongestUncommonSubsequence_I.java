package practice.leetcode.ez;

/**
 * tricky tricky tricky
 */
public class LongestUncommonSubsequence_I {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence_I l = new LongestUncommonSubsequence_I();
        String a = "abc";
        String b = "abcd";
        System.out.println(l.findLUSlength(a,b));
    }
}
