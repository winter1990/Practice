package practice.leetcode.hard;

import java.util.Arrays;

/**
 * @binarysearch
 * @dp
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the
 * width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 *
 * [2 3][4 5][4 6][6 7] -> [2 3][4 5][6 7]
 * [1 9][2 3][4 10][5 6][7 9]
 *
 * start with 1d array
 *   to fit the current into next, we need the length to be smaller
 *   so, sort by width first
 * then consider the heights
 *   if sort by height in ascending order
 *     there might have tied width - [1 3][1 4][1 5]
 *     we need to choose one that fits the next group of envelopes that has larger width - [4 6][4 7][4 9]
 *     we have to try one by which increases a lot of time complexity
 *   if sort by heights in descending order
 *     we are trying to find the longest ascending sub sequence of heights where widths are ascending
 *
 * then we can perform binary search on height
 * use an array to store the height of the sequence
 * for each envelope
 *   binary search in dp array, l = 0, r = length of sub sequence, start with 0
 *   find which envelope in dp should be replaced
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 2) return envelopes.length;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int n = envelopes.length;
        int[] dp = new int[n];
        int res = 0;
        for (int[] e : envelopes) {
            int l = 0, r = res;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (dp[mid] < e[1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            dp[l] = e[1];
            if (l == res) res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] e = {{1,2},{1,5},{3,4},{6,8},{9,10}};
        int[][] e = {{30,50},{12,2},{3,4},{12,15}};
        RussianDollEnvelopes r = new RussianDollEnvelopes();
        System.out.println(r.maxEnvelopes(e));
    }
}
