package practice.leetcode.medium;

/**
 * @array
 * @math
 *
 * 2736 -> 7236
 * 9973 -> 9973
 * 9793 -> 9973
 * convert to string
 * check if it is sorted in descending order
 * find largest digit:
 *   if the largest is not at most significant digit, swap with first
 *   if the largest is at leftmost digit:
 *     second largest, another string in descending order
 *
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] cs = (num + "").toCharArray();
        maxSwap(cs, 0);
        return Integer.valueOf(new String(cs));
    }

    private void maxSwap(char[] cs, int start) {
        if (start == cs.length) return;
        int maxIndex = start;
        for (int i = start + 1; i < cs.length; i++) {
            if (cs[i] > cs[start] && cs[i] >= cs[maxIndex]) maxIndex = i;
        }
        if (maxIndex != start) {
            char tmp = cs[start];
            cs[start] = cs[maxIndex];
            cs[maxIndex] = tmp;
            return;
        }
        maxSwap(cs, start + 1);
    }

    /**
     * optimization:
     * track the index of each digit - for the same digit,
     */
    public int maximumSwap1(int num) {
        char[] cs = (num + "").toCharArray();
        int[] idx = new int[10];
        for (int i = 0; i < cs.length; i++) idx[cs[i] - '0'] = i;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 9; j > cs[i] - '0'; j--) {
                if (idx[j] > i) {
                    char tmp = cs[i];
                    cs[i] = cs[idx[j]];
                    cs[idx[j]] = tmp;
                    return Integer.valueOf(new String(cs));
                }
            }
        }
        return num;
    }
}
