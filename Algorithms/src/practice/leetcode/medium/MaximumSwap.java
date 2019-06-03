package practice.leetcode.medium;

/**
 * @array
 * @math
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * problems to solve:
 * 1. to get the maximum, largest number at head, second largest at second place...
 * 2. if duplicates maximum digits can be chosen, choose the right most one
 *
 * 2736 -> 7236
 * 9973 -> 9973
 * 9793 -> 9973
 * number -> string -> char array
 * find largest digit
 *   from right to left
 *   if same with the number at 0, continue to next digit
 *   use an array to track the RIGHTMOST index for each digit
 *   for each digit in number from left to right, search the index array from right to left
 *     stop searching if index[right] > left
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] cs = (num + "").toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < cs.length; i++) index[cs[i] - '0'] = i;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 9; j > cs[i] - '0'; j--) {
                if (index[j] > i) {
                    char tmp = cs[i];
                    cs[i] = cs[index[j]];
                    cs[index[j]] = tmp;
                    return Integer.valueOf(new String(cs));
                }
            }
        }
        return num;
    }
}
