package practice.leetcode.medium;

import java.util.Random;
import java.util.TreeMap;

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
        int[] preSum;
        Random random;
        public Solution(int[] w) {
            preSum = w;
            for (int i = 1; i < w.length; i++) preSum[i] += preSum[i - 1];
            random = new Random();
        }

        public int pickIndex() {
            int rand = random.nextInt(preSum[preSum.length - 1]) + 1; // [1, total]
            int s = 0, e = preSum.length - 1;
            while (s < e) {
                int mid = s + (e - s) / 2;
                if (preSum[mid] == rand) {
                    return mid;
                } else if (preSum[mid] > rand) {
                    e = mid;
                } else {
                    s = mid + 1;
                }
            }
            return s;
        }
    }

    // intuitive solution
    // not efficient enough with linear search
    class Solution1 {
        int[] w;
        int total = 0;
        Random random;
        public Solution1(int[] w) {
            this.w = w;
            for (int i : w) total += i;
            random = new Random();
        }

        public int pickIndex() {
            int r = random.nextInt(total) + 1; // [1, total]
            int i = 0;
            while (r > w[i]) {
                r -= w[i++];
            }
            return i;
        }
    }

    class Solution2 {
        TreeMap<Integer, Integer> map;
        Random random;
        int sum;
        public Solution2(int[] w) {
            map = new TreeMap<>();
            sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                map.put(sum, i);
            }
            random = new Random();
        }

        public int pickIndex() {
            int rand = random.nextInt(sum) + 1;
            Integer key = map.ceilingKey(rand);
            return map.get(key);
        }
    }
}

