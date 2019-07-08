package practice.leetcode.medium;

/**
 * @string
 */
public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.length() == 0) return new int[]{};
        int degree = getDegree(seq);
        int n = seq.length(), d1 = 0, d2 = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                if (d1 < degree / 2) {
                    d1++;
                    res[i] = 0;
                } else {
                    d2++;
                    res[i] = 1;
                }
            } else {
                if (d2 != 0) {
                    res[i] = 1;
                    d2--;
                } else {
                    res[i] = 0;
                    d1--;
                }
            }
        }
        return res;
    }

    private int getDegree(String s) {
        int d = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                d++;
            } else {
                d--;
            }
            max = Math.max(max, d);
        }
        return max;
    }

    /**
     * optimization
     */
    public int[] maxDepthAfterSplit1(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        for (int i = 0, d = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                res[i] = d % 2;
                d++;
            } else {
                d--;
                res[i] = d % 2;
            }
        }
        return res;
    }
}
