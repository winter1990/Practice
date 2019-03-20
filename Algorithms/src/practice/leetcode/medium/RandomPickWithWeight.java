package practice.leetcode.medium;

import java.util.Random;

/**
 * @binarysearch
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex
 * which randomly picks an index in proportion to its weight.
 * 1 <= w.length <= 10000
 *
 * we need to understand the proportion to its weight
 * for example:
 *  0 1 2 3 4
 * [2 1 3 5 9]
 * => [0 0 1 2 2 2 3 3 3 3 3 4 ....4] totally 9 4s
 * then we randomly pick an index, we want to know what is the number
 *
 * {2,5,3,4} => wsum[] = {2,7,10,14}
 * then index is in range [1, 14]
 * idx in [1,2] return 0
 * idx in [3,7] return 1
 * idx in [8,10] return 2
 * idx in [11,14] return 3
 */
public class RandomPickWithWeight {
    class Solution {
        int[] wsum;
        Random rand;
        public Solution(int[] w) {
            rand = new Random();
            wsum = w;
            for (int i = 1; i < wsum.length; i++) wsum[i] += wsum[i - 1];
        }

        public int pickIndex() {
            int n = wsum.length;
            int index = rand.nextInt(wsum[n - 1]) + 1;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (wsum[mid] == index) {
                    return mid;
                } else if (wsum[mid] < index) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

}

