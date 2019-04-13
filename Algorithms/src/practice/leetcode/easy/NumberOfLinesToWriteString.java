package practice.leetcode.easy;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        if (S == null || S.length() == 0) {
            return res;
        }
        int line = 1;
        int count = 0;
        for (char c : S.toCharArray()) {
            int w = widths[c - 'a'];
            if (count + w > 100) {
                line++;
                count = 0;
            }
            count += w;
        }
        res[0] = line;
        res[1] = count;
        return res;
    }
}
