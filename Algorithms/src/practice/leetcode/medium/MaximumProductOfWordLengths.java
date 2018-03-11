package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * for each word in list,use an integer to track which chars it contains
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int checker = 0;
            for (char c : words[i].toCharArray()) {
                checker |= 1 << (c - 'a');
            }
            arr[i] = checker;
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] str = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        MaximumProductOfWordLengths m = new MaximumProductOfWordLengths();
        m.maxProduct(str);

    }
}
